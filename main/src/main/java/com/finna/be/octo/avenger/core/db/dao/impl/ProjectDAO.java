package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.Collection;

import javax.persistence.TypedQuery;

import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.model.DBProject;

public class ProjectDAO extends BasicDAO<DBProject> implements IProjectDAO {

	private static final String SELECT_ALL_PROJECTS = "SELECT p FROM PROJECTS p";

	public Collection<DBProject> getProjects() {
		TypedQuery<DBProject> projectsQuery = entityManager.createQuery(SELECT_ALL_PROJECTS, DBProject.class);
		return projectsQuery.getResultList();
	}

	public DBProject getById(long id) {
		return findById(DBProject.class, id);
	}

}
