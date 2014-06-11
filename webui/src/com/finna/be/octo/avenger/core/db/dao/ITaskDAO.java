package com.finna.be.octo.avenger.core.db.dao;

import java.util.Collection;

import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBTask;

public interface ITaskDAO {
	
	public long createTask(DBTask task) throws DAOException;
	
	public DBTask getById(long id);
	
	public Collection<DBTask> getTasks();

	public Collection<DBTask> getTasksWithProjectId(long projectId);
	
	public Collection<DBTask> getTasksWithUserId(long userId);
	
	public void updateTask(DBTask task) throws DAOException;

}
