package com.finna.be.octo.avenger.core.model;

import java.sql.Timestamp;

public interface IDBComment {
	
	public long getId();
	
	public String getContent();
	
	public Timestamp getTimestamp();

	public IDBUser getAuthor();
	
}
