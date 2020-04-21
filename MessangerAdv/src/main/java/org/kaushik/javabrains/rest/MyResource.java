package org.kaushik.javabrains.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathparam}/test")
@Produces(MediaType.TEXT_PLAIN)
public class MyResource {
	
	@PathParam("pathparam") private String pathParamExample;
	@QueryParam("queryparam") private String queryParamExample;
	
	@GET
	public String getTestmethod() {
		//http://localhost:8080/MessangerAdv/webapi/paramvalue/test?queryparam=queryvalue
		return "pathParamExample = " + pathParamExample + "  queryParamExample = " + queryParamExample + "";
	}
	
	/*@GET
	public String getTestmethod(@PathParam("pathparam") String pathparam) {
		return "MyResource";
	}*/
	
	/*@GET
	public String getTestmethod() {
		return "MyResource";
	}*/

}
