package com.finna.be.octo.avenger.core.db.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class DBComment {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;
	
	@OneToOne
	@JoinColumn(name = "AUTHOR_ID")
	private DBUser author;
	
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

}
