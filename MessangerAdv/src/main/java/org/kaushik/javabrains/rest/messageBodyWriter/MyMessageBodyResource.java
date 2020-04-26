package org.kaushik.javabrains.rest.messageBodyWriter;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
//if Accept=TEXT_PLAIN at client
public class MyMessageBodyResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date test() {
		return Calendar.getInstance().getTime();
		
	}
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Hi";
		
	}*/

}
