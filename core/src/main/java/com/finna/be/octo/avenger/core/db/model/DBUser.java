package com.finna.be.octo.avenger.core.db.model;

public class DBUser implements IDBUser {

	private long id;
	private String username;
	private String fullName;
	private String email;
	
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

}
