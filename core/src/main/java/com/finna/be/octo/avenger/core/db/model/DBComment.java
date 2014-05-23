package com.finna.be.octo.avenger.core.db.model;

import java.sql.Timestamp;

public class DBComment implements IDBComment {

	private long id;
	private String content;
	private Timestamp timestamp;
	private IDBUser author;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public IDBUser getAuthor() {
		return author;
	}
	
	public void setAuthor(IDBUser author) {
		this.author = author;
	}

}
