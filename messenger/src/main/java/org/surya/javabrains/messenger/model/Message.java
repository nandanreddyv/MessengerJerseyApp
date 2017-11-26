package org.surya.javabrains.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {
	
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(String author,String message,long id ) {
		
		this.author=author;
		this.message=message;
		this.id=id;
		this.created=new Date();
		
	}

	private String author;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private Date created;
	private String message;
	private long id;
	
}
