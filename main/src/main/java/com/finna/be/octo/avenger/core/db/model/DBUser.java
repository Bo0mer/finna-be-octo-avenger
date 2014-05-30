package com.finna.be.octo.avenger.core.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "USERS")
@SequenceGenerator(name = "USERS_SEQ", initialValue=1, allocationSize=100)
public class DBUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
	private long id;
	
	@Column(name = "USER_NAME", unique = true)
	private String username;
	
	@Column(name = "USER_PASS")
	private String password;
	
	@Column(name = "FULL_NAME", unique = true)
	private String fullName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "author", cascade=CascadeType.PERSIST)
	private List<DBComment> comments;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST)
	private List<DBTask> tasks;
	
	public DBUser() {
		comments = new ArrayList<DBComment>();
		tasks = new ArrayList<DBTask>();
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
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
	
	public void addComment(DBComment comment) {
		if (!comments.contains(comment)) {
			comments.add(comment);
			comment.setAuthor(this);
		}
	}
	
	public List<DBTask> getTasks() {
		return tasks;
	}

	public void addTask(DBTask task) {
		if (!tasks.contains(task)) {
			tasks.add(task);
			task.setUser(this);
		}
	}
	
}
