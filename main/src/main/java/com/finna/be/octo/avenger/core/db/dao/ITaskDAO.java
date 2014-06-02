package com.finna.be.octo.avenger.core.db.dao;

import java.util.Collection;

import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public interface ITaskDAO {
	
	public long createTask(DBTask task) throws DAOException;
	
	public DBTask getById(long id);
	
	public Collection<DBTask> getTasks();

}
