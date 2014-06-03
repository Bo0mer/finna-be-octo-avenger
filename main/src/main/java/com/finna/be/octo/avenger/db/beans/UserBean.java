package com.finna.be.octo.avenger.db.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.finna.be.octo.avenger.core.db.model.DBUser;

@Stateless
@LocalBean
public class UserBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	public DBUser getUserById(long id) {
		return entityManager.find(DBUser.class, id);
	}
	
	public long addUser(DBUser user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getId();
	}
}
