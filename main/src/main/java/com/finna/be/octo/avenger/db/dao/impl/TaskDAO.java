package com.finna.be.octo.avenger.db.dao.impl;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.model.DBTask;

public class TaskDAO extends BasicDAO implements ITaskDAO {

	public long createTask(DBTask task) {
		entityManager.getTransaction().begin();
		entityManager.persist(task);
		entityManager.getTransaction().commit();
		return task.getId();
	}

	public DBTask findById(long id) {
		DBTask task = entityManager.find(DBTask.class, id);
		return task;
	}

}
