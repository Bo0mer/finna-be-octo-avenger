package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.List;

import com.finna.be.octo.avenger.core.db.dao.IProjectDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBProject;

public class ProjectDAO extends BasicDAO<DBProject> implements IProjectDAO {

	private static final String SELECT_ALL_PROJECTS = "SELECT p FROM PROJECTS p";

	@Override
	public List<DBProject> getProjects() {
		return getQueryResult(SELECT_ALL_PROJECTS, DBProject.class);
	}

	@Override
	public DBProject getById(long id) {
		return findById(DBProject.class, id);
	}

	@Override
	public long createProject(DBProject project) throws DAOException {
		persistObject(project);
		return project.getId();
	}

}
