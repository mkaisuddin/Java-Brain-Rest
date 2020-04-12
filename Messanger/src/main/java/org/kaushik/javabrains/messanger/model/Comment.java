package org.kaushik.javabrains.messanger.model;

import java.util.Date;

public class Comment {
	private long id;
	private String message;
	private Date created;
	private String author;
	
	public Comment() {

	}
	
	public Comment(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
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
	public Date getCraeted() {
		return created;
	}
	public void setCraeted(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
