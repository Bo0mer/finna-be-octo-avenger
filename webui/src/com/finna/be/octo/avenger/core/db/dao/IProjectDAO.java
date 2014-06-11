package com.finna.be.octo.avenger.core.db.dao;

import java.util.Collection;

import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBProject;

public interface IProjectDAO {

	public Collection<DBProject> getProjects();
	
	public DBProject getById(long projectId);
	
	public long createProject(DBProject project) throws DAOException;
	
}
