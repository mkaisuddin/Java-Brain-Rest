package org.kaushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/MessangerAdv22/webapi/messages/1")
								.request()
								.get();
		//System.out.println(response);
		//System.out.println(response.readEntity(Message.class).getMessage());
		Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());

	}

}
