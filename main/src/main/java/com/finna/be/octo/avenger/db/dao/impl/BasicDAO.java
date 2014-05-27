package com.finna.be.octo.avenger.db.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.finna.be.octo.avenger.core.db.connection.DBConfiguration;

public abstract class BasicDAO {
	
	protected final EntityManager entityManager;
	
	public BasicDAO() {
		entityManager = Persistence.createEntityManagerFactory(DBConfiguration.getPersistanceUnitName())
						.createEntityManager();
	}
	
	protected void persistObject(Object object) {
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
	}
	
}
