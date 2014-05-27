package com.finna.be.octo.avenger.core.db.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "COMMENTS")
@SequenceGenerator(name = "COMMENTS_SEQ", initialValue=1, allocationSize=100)
public class DBComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQ")
	private long id;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "AUTHOR_ID")
	private DBUser author;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "TASK_ID")
	private DBTask task;
	
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

	public DBUser getAuthor() {
		return author;
	}
	
	public void setAuthor(DBUser author) {
		this.author = author;
	}
	
	public DBTask getTask() {
		return task;
	}
	
	public void setTask(DBTask task) {
		this.task = task;
	}

}
