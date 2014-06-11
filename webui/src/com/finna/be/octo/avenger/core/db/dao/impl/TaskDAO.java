package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.Collection;
import java.util.List;

import com.finna.be.octo.avenger.core.db.dao.ITaskDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBTask;

public class TaskDAO extends BasicDAO<DBTask> implements ITaskDAO {

	private static final String SELECT_ALL_TASKS = "SELECT t FROM TASKS t";
	private static final String SELECT_TASK_BY_PROJECT_ID = "SELECT t FROM TASKS t WHERE t.project.id = %s ORDER BY t.status ASC, t.priority DESC";
	private static final String SELECT_TASK_BY_USER_ID = "SELECT t FROM TASKS t WHERE t.user.id = %s ORDER BY t.status ASC, t.priority DESC";

	@Override
	public long createTask(DBTask task) throws DAOException {
		persistObject(task);
		return task.getId();
	}

	@Override
	public DBTask getById(long id) {
		return findById(DBTask.class, id);
	}

	@Override
	public List<DBTask> getTasks() {
		return getQueryResult(SELECT_ALL_TASKS, DBTask.class);
	}

	@Override
	public Collection<DBTask> getTasksWithProjectId(long projectId) {
		return getQueryResult(String.format(SELECT_TASK_BY_PROJECT_ID, projectId), DBTask.class);
	}

	@Override
	public Collection<DBTask> getTasksWithUserId(long userId) {
		return getQueryResult(String.format(SELECT_TASK_BY_USER_ID, userId), DBTask.class);
	}

	@Override
	public void updateTask(DBTask task) throws DAOException {
		mergeObject(task);
	}

}
