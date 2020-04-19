package org.kaushik.javabrains.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.TEXT_PLAIN)
public class MyResource {
	
	@GET
	public String getTestmethod() {
		return "MyResource";
	}

}
