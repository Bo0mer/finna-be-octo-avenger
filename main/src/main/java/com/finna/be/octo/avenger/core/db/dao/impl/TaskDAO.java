package com.finna.be.octo.avenger.core.db.dao.impl;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public class TaskDAO extends BasicDAO<DBTask>implements ITaskDAO {

	public long createTask(DBTask task) throws DAOException {
		persistObject(task);
		return task.getId();
	}

	public DBTask getById(long id) {
		return findById(DBTask.class, id);
	}

}
