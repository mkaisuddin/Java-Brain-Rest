package org.kaushik.javabrains.messanger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String authore;
	private Map<Long, Comment> comments = new HashMap<>();
	
	public Message() {
		/*{
			"authore": "author11",
			"created": "2020-04-11T12:38:07.556Z[UTC]",
			"id": 1,
			"message": "Message11"
		}*/
	}
	
	public Message(long id, String message, String authore) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.authore = authore;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthore() {
		return authore;
	}
	public void setAuthore(String authore) {
		this.authore = authore;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
}
