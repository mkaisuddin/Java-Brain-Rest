package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		/*Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/MessangerAdv22/webapi/messages/1")
								.request()
								.get();
		//System.out.println(response);
		//System.out.println(response.readEntity(Message.class).getMessage());
		Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());*/
		
		//Or
		/*Message message = client.target("http://localhost:8080/MessangerAdv22/webapi/messages/1")
		.request(MediaType.TEXT_PLAIN)
		.get(Message.class);*/
		
		//OR
		/*String message = client.target("http://localhost:8080/MessangerAdv22/webapi/messages/1")
		.request(MediaType.TEXT_PLAIN)
		.get(String.class);
		System.out.println(message);*/
		
		//Some Best Practice
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget =  client.target("http://localhost:8080/MessangerAdv22/webapi/");
		WebTarget massageTarget = baseTarget.path("messages");
		WebTarget singleMassageTarget = massageTarget.path("{messageId}");
		/*System.out.println(baseTarget);
		System.out.println(massageTarget);
		System.out.println(singleMassageTarget);*/
		
		//GET
		Message message = singleMassageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(message.getMessage());
		
		//POST
		Message newMessage = new Message(4, "message4", "author4");
		Response postResponse = massageTarget
				.request()
				.post(Entity.json(newMessage));
		Message createdMessage = postResponse.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());
	}

}
