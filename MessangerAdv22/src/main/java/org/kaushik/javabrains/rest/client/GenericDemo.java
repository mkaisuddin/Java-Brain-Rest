package org.kaushik.javabrains.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		List<Message> messages = client.target("http://localhost:8080/MessangerAdv22/webapi/")
				.path("messages")
				.queryParam("year", 2015)
				.request(MediaType.APPLICATION_JSON)
				// instent of .get(Message.Class) use .get() for Generic Type
				//.get();
				.get( new GenericType<List<Message>>() {});
		
		System.out.println(messages);
	}

}
