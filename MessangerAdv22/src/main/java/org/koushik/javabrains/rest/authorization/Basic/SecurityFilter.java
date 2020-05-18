package org.koushik.javabrains.rest.authorization.Basic;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
//Authorization
//Base 64 encoding authHeader= Basic dXNlcjpwYXNzd29yZA==
//secured/message
public class SecurityFilter implements ContainerRequestFilter{
	private static final String SECURED_URL_PRIFIX = "secured";
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PRIFIX = "Basic ";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PRIFIX)) {
			 List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			 if(authHeader != null && authHeader.size() > 0) {
				 confirmAuthorization(authHeader);
			 }
			 Response unauthorizeStatus = Response
					 .status(Response.Status.UNAUTHORIZED)
					 .entity("User can not access the resource")
					 .build();
					 
			 requestContext.abortWith(unauthorizeStatus);
			 
		}
		
		
	}

	private void confirmAuthorization(List<String> authHeader) {
		 
		 String authToken = authHeader.get(0); //Basic dXNlcjpwYXNzd29yZA==
		 authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PRIFIX, "");//dXNlcjpwYXNzd29yZA==
		 String decodeString = Base64.decodeAsString(authToken);//username:password
		 StringTokenizer stringTokenizer = new StringTokenizer(decodeString, ":");
		 String username = stringTokenizer.nextToken();
		 String password = stringTokenizer.nextToken();
		 
		 if(username.equals("user") && password.equals("password")) {
			 System.out.println("hhhh");
			 
			 return;
		 }
		
	}
	

}
