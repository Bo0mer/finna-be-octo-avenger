package com.finna.be.octo.avenger.core.db.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.finna.be.octo.avenger.core.db.connection.DBConfiguration;

public abstract class BasicDAO<T> {
	
	protected final EntityManager entityManager;
	
	public BasicDAO() {
		entityManager = Persistence.createEntityManagerFactory(DBConfiguration.getPersistanceUnitName())
						.createEntityManager();
	}
	
	protected T findById(Class<T> clazz, long id) {
		return entityManager.find(clazz, id);
	}
	
	protected void persistObject(Object object) {
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
	}
	
}
