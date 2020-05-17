package org.kaushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationsDemo {

	// http://localhost:8080/MessangerAdv22/webapi/messages?year=2015
	public static void main(String[] args) {
		InvocationsDemo invocationsDemo = new InvocationsDemo();
		Invocation invocations = invocationsDemo.prepareRequewstForMessageByYear(2015);
		Response responce = invocations.invoke();
		System.out.println(responce.getStatus());
	}

	private Invocation prepareRequewstForMessageByYear(int year) {
		Client client = ClientBuilder.newClient();
		return client.target("http://localhost:8080/MessangerAdv22/webapi/")
				.path("messages")
				.request(MediaType.APPLICATION_JSON)
				// instent of get use buildGet for Invocations
				.buildGet();
				
	}

}
