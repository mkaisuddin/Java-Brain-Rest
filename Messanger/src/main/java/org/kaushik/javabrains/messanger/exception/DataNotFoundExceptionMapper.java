package org.kaushik.javabrains.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kaushik.javabrains.messanger.model.ErrorMessage;

@Provider //register this Mapper into JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://test");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}


}
