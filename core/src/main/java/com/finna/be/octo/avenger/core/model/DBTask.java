package com.finna.be.octo.avenger.core.model;

import java.util.List;

public class DBTask implements IDBTask {

	private long id;
	private String name;
	private String description;
	private IDBUser user;
	private List<IDBComment> comments;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public IDBUser getUser() {
		return user;
	}
	
	public void setUser(IDBUser user) {
		this.user = user;
	}

	public List<IDBComment> getComments() {
		return comments;
	}
	
	public void setComments(List<IDBComment> comments) {
		this.comments = comments;
	}

}
