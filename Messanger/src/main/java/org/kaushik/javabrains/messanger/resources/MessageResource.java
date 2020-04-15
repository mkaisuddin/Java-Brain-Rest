package org.kaushik.javabrains.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.kaushik.javabrains.messanger.model.Message;
import org.kaushik.javabrains.messanger.services.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	//Merge with Pagination and Filtering
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}*/ 
	
	//Filtering
	//Merge with Pagination and Filtering
	//messages?year=2015
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int year){
		if (year > 0)
			return messageService.getAllMessagesForYear(year);
		return messageService.getAllMessages();
	}*/
	
	
	//Pagination and Filtering
	//messages?year=2015
	//messages:start=2&size=1
	@GET
	public List<Message> getMessage(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size") int size){
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);//messages?year=2015
		}
		if(start >= 0 && size >= 0) {
			return messageService.getAllMessagesPaginated(start, size);//messages:start=2&size=1
		}
		return messageService.getAllMessages();//message
	}
		
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo){
		//return messageService.getMessage(id);
		Message message = messageService.getMessage(id);
		//HATEOAS
		message.addLink(getUriInfoForSelf(uriInfo, message), "self");
		message.addLink(getUriInfoForProfile(uriInfo, message), "profile");
		message.addLink(getUriInfoForComments(uriInfo, message), "comments");		
		return message;
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long id){
		return messageService.removeMessage(id);
	}
	
	
	@Path("/{messageId}/comments")
	/*************
	Implementing Subresources
	messages/{messageId}/comments/
	*************/
	public CommentsResource getCommentsResource(){
		return new CommentsResource();
	}
	
	//HATEOAS
	public String getUriInfoForSelf(UriInfo uriInfo, Message message){
		return uriInfo.getBaseUriBuilder()      	//http://localhost:8080/messanger/webapi/
				.path(MessageResource.class)			//										/messages
				.path(Long.toString(message.getId()))	//												/{messageId}
				.build()
				.toString();
	}
	
	//HATEOAS
	private String getUriInfoForProfile(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()      	//http://localhost:8080/messanger/webapi/
				.path(ProfileResource.class)			//										/profiles
				.path(message.getAuthore())	//														/{authoreName}
				.build()
				.toString();
	}
	
	//HATEOAS
	private String getUriInfoForComments(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()      				 	//http://localhost:8080/messanger/webapi/
				.path(MessageResource.class)						//								/messages
				.path(MessageResource.class, "getCommentsResource") //									/{messageId}/comments
				.resolveTemplate("messageId", message.getId()) 		//									replace dynamic value{messageId}
				.path(CommentsResource.class)						//								/
				.build()
				.toString();
	}
}

/**
uriInfo
		.getAbsolutePathBuilder() or getBaseUriBuilder()
			
			UriBuilder
				.path("blah")         		/blah/
				.path("Anyresource.class")	/messages/
*/
	