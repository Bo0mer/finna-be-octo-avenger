package com.finna.be.octo.avenger.core.db.dao.impl;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;

public class TaskDAO extends BasicDAO<DBTask>implements ITaskDAO {

	public long createTask(DBTask task) {
		persistObject(task);
		return task.getId();
	}

	public DBTask getById(long id) {
		return findById(DBTask.class, id);
	}

}
