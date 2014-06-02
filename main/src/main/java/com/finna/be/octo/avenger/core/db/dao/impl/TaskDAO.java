package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.List;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public class TaskDAO extends BasicDAO<DBTask> implements ITaskDAO {

	private static final String SELECT_ALL_TASKS = "SELECT t FROM TASKS t";

	public long createTask(DBTask task) throws DAOException {
		persistObject(task);
		return task.getId();
	}

	public DBTask getById(long id) {
		return findById(DBTask.class, id);
	}

	public List<DBTask> getTasks() {
		return getQueryResult(SELECT_ALL_TASKS, DBTask.class);
	}

}
