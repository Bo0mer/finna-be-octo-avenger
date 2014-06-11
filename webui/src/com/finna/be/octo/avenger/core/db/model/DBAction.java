package com.finna.be.octo.avenger.core.db.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "ACTIONS")
@SequenceGenerator(name = "ACTIONS_SEQ", initialValue=1, allocationSize=1)
public class DBAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQ")
	private long id;
	
	@Column(name = "ACTION")
	private ActionType action;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PERFORMED_AT")
	private Timestamp performedAt;
	
	@Column(name = "OBJECT")
	private String object;
	
	@Column(name = "OBJECT_ID")
	private long objectId;
	
	@Column(name = "FIELD")
	private String field;
	
	@Column(name = "OLD_VALUE")
	private String oldValue;
	
	@Column(name = "NEW_VALUE")
	private String newValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ActionType getAction() {
		return action;
	}

	public void setAction(ActionType action) {
		this.action = action;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getPerformedAt() {
		return performedAt;
	}

	public void setPerformedAt(Timestamp performedAt) {
		this.performedAt = performedAt;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}
	
	public long getObjectId() {
		return objectId;
	}
	
	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	
}
