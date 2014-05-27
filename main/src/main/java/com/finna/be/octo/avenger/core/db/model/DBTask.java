package com.finna.be.octo.avenger.core.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "TASKS")
public class DBTask  {

	@Id
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private DBUser user;
	
	@OneToMany
	@JoinColumn(name = "TASK_ID", referencedColumnName = "ID")
	private List<DBComment> comments;

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

	public DBUser getUser() {
		return user;
	}
	
	public void setUser(DBUser user) {
		this.user = user;
	}

	public List<DBComment> getComments() {
		return comments;
	}
	
	public void setComments(List<DBComment> comments) {
		this.comments = comments;
	}

}
