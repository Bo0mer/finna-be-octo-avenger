package com.finna.be.octo.avenger.core.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "USERS")
public class DBUser {

	@Id
	private long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	private List<DBComment> comments;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username	;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setComments(List<DBComment> comments) {
		this.comments = comments;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<DBComment> getComments() {
		return comments;
	}

}
