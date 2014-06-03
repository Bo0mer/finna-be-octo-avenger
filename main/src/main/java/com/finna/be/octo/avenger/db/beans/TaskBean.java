package com.finna.be.octo.avenger.db.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.finna.be.octo.avenger.core.db.model.DBTask;

@Stateless
@LocalBean
public class TaskBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	public DBTask getTaskById(long id) {
		return entityManager.find(DBTask.class, id);
	}
	
	public long addTask(DBTask task) {
		entityManager.persist(task);
		entityManager.flush();
		entityManager.merge(task.getProject());
		entityManager.merge(task.getUser());
		entityManager.flush();
		return task.getId();
	}

}
