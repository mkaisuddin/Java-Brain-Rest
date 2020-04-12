package org.kaushik.javabrains.messanger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.kaushik.javabrains.messanger.database.DatabaseClass;
import org.kaushik.javabrains.messanger.model.Comment;
import org.kaushik.javabrains.messanger.model.ErrorMessage;
import org.kaushik.javabrains.messanger.model.Message;

public class CommentService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	//add WebApplicationException
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage = new ErrorMessage("Not found", 500, "http://test");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
		
		Message message = messages.get(messageId);
		if(message == null) {
			throw new WebApplicationException(response);
		}
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentId);
		if( comment == null) {
			throw new WebApplicationException(response);
		}
		return comment;
	} 
	
	/*public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	} */
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateCommentlong(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}
