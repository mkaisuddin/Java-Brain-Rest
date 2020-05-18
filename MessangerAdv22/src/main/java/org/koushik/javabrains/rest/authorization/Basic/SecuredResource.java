package org.koushik.javabrains.rest.authorization.Basic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
//http://localhost:8080/MessangerAdv22/webapi/secured/
public class SecuredResource {
	
	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN)
	////http://localhost:8080/MessangerAdv22/webapi/secured/message
	public String getSecuredMethod() {
		return "I am secured resource";
	}

}
