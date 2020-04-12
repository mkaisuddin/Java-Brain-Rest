package org.kaushik.javabrains.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kaushik.javabrains.messanger.model.Comment;
import org.kaushik.javabrains.messanger.services.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResource {

	///messages/{messageId}/comments/{commentId}
	
	CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateCommentlong(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment removeComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.removeComment(messageId, commentId);
	}
}
