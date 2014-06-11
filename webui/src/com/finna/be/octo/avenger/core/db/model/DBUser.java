package com.finna.be.octo.avenger.core.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "USERS")
@SequenceGenerator(name = "USERS_SEQ", initialValue=1, allocationSize=1)
public class DBUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
	private long id;
	
	@Column(name = "USER_NAME", unique = true)
	private String username;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@ManyToMany
	@JoinTable(
			name = "USER_TASK_SUBSCRIBTION",
			joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name = "TASK_ID", referencedColumnName = "ID")})
	List<DBTask> subscribedTasks;

	public DBUser() {
		subscribedTasks = new ArrayList<DBTask>();
	}
 	
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
	
	public List<DBTask> getSubscribedTasks() {
		return subscribedTasks;
	}
	
	public void setSubscribedTasks(List<DBTask> subscribedTasks) {
		this.subscribedTasks = subscribedTasks;
	}
	
}
