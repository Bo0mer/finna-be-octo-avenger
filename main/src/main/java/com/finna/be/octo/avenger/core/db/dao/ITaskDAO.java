package com.finna.be.octo.avenger.core.db.dao;

import com.finna.be.octo.avenger.core.db.model.DBTask;

public interface ITaskDAO {
	
	public long createTask(DBTask task);
	
	public DBTask findById(long id);
	
}
