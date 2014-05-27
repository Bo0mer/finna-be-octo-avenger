package com.finna.be.octo.avenger.core.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "TASKS")
@SequenceGenerator(name="TASKS_SEQ", initialValue=1, allocationSize=100)
public class DBTask  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASKS_SEQ")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private DBUser user;
	
	@OneToMany(mappedBy = "task", cascade=CascadeType.PERSIST)
	@JoinColumn(name = "TASK_ID", referencedColumnName = "ID")
	private List<DBComment> comments;

	public DBTask() {
		comments = new ArrayList<DBComment>();
	}
	
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
	
	public void addComment(DBComment comment) {
		if (!comments.contains(comment)) {
			comments.add(comment);
			comment.setTask(this);
		}
	}

}