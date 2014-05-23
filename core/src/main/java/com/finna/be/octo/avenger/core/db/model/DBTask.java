package com.finna.be.octo.avenger.core.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "TASKS")
public class DBTask implements IDBTask {

	@Id
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private IDBUser user;
	
	@OneToMany
	@JoinColumn(name = "TASK_ID", referencedColumnName = "ID")
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
