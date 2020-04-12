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
import javax.ws.rs.core.MediaType;

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
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
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
	
	//*************
	//Implementing Subresources
	//messages/{messageId}/comments/
	//*************
	@Path("/{messageId}/comments")
	public CommentsResource getCommentsResource(){
		return new CommentsResource();
	}
}
