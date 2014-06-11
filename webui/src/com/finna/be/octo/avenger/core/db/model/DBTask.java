package com.finna.be.octo.avenger.core.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.finna.be.octo.avenger.core.db.model.DBProject;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import javax.persistence.ManyToOne;

@Entity(name = "TASKS")
@SequenceGenerator(name="TASKS_SEQ", initialValue=1, allocationSize=1)
public class DBTask  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASKS_SEQ")
	private long id;
	
	@Column(name = "NAME", unique = true)
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DUE_DATE")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@Column(name = "STATUS")
	private TaskStatus status;
	
	@Column(name = "PRIORITY")
	private int priority;

	@ManyToOne
	private DBProject project;

	@ManyToOne
	private DBUser user;

	public DBTask() {
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
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public TaskStatus getStatus() {
		return status;
	}
	
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public DBProject getProject() {
	    return project;
	}

	public void setProject(DBProject project) {
	    this.project = project;
	}

	public DBUser getUser() {
	    return user;
	}

	public void setUser(DBUser user) {
	    this.user = user;
	}

}
