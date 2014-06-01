package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.model.DBProject;

public class ProjectDAO extends BasicDAO<DBProject> implements IProjectDAO {

	private static final String SELECT_ALL_PROJECTS = "SELECT p FROM PROJECTS p";

	public Collection<DBProject> getProjects() {
		final EntityManager entityManager = getEntityManager();
		final TypedQuery<DBProject> projectsQuery = entityManager.createQuery(SELECT_ALL_PROJECTS, DBProject.class);
		final List<DBProject> projects = projectsQuery.getResultList();
		entityManager.close();
		return projects;
	}

	public DBProject getById(long id) {
		return findById(DBProject.class, id);
	}

}
