package com.finna.be.octo.avenger.core.db.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import javax.persistence.ManyToOne;

@Entity(name = "COMMENTS")
@SequenceGenerator(name = "COMMENTS_SEQ", initialValue=1, allocationSize=1)
public class DBComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQ")
	private long id;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;

	@ManyToOne
	private DBTask task;

	@ManyToOne
	private DBUser user;

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

	public DBTask getTask() {
	    return task;
	}

	public void setTask(DBTask task) {
	    this.task = task;
	}

	public DBUser getUser() {
	    return user;
	}

	public void setUser(DBUser user) {
	    this.user = user;
	}

}
