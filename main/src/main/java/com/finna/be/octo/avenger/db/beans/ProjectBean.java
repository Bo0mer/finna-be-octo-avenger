package com.finna.be.octo.avenger.db.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.finna.be.octo.avenger.core.db.model.DBProject;

@Stateless
@LocalBean
public class ProjectBean {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public DBProject getProjectById(long id) {
		return entityManager.find(DBProject.class, id);
	}
	
	public long addProject(DBProject project) {
		entityManager.persist(project);
		entityManager.flush();
		return project.getId();
	}

}
