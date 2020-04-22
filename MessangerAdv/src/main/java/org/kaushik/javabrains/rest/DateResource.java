package org.kaushik.javabrains.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
//date/tommorow
//date/today
//date/yesterday
public class DateResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequesteDate(@PathParam("dateString") MyDate mydate) {
		return mydate.toString();
	}
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequesteDate(@PathParam("dateString") String dateString) {
		return "got " + dateString +"";
	}*/

}
