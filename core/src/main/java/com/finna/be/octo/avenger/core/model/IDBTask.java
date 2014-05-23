package com.finna.be.octo.avenger.core.model;

import java.util.List;

public interface IDBTask {

	public long getId();
	
	public String getName();
	
	public String getDescription();
	
	public IDBUser getUser();
	
	public List<IDBComment> getComments();
	
}
