package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.finna.be.octo.avenger.core.db.connection.DBConfiguration;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public abstract class BasicDAO<T> {

	private final EntityManagerFactory emf;

	public BasicDAO() {
		emf = Persistence.createEntityManagerFactory(DBConfiguration
				.getPersistanceUnitName());
	}

	protected T findById(Class<T> clazz, long id) {
		final EntityManager entityManager = getEntityManager();
		final T result = entityManager.find(clazz, id);
		entityManager.close();
		return result;
	}

	protected void persistObject(T object) throws DAOException {
		final EntityManager entityManager = getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(object);
			transaction.commit();
		} catch (RollbackException e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new DAOException("Error persisting object");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	protected List<T> getQueryResult(String query, Class<T> clazz) {
		final EntityManager entityManager = getEntityManager();
		final TypedQuery<T> projectsQuery = entityManager.createQuery(query,
				clazz);
		final List<T> result = projectsQuery.getResultList();
		entityManager.close();
		return result;
	}

	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
