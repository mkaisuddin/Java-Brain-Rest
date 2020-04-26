package org.kaushik.javabrains.rest.customMediaTypes;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
//if Accept=text/shortDate at client
public class MyCustomMediaTypeResource {
	
	@GET
	@Produces(value= {MediaType.TEXT_PLAIN, "text/shortDate"})
	public Date test() {
		return Calendar.getInstance().getTime();
		
	}

	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Hi";
		
	}*/
}
