package com.finna.be.octo.avenger.core.db.dao.impl;

import javax.persistence.EntityManager;

import com.finna.be.octo.avenger.core.db.dao.IRolesDAO;
import com.finna.be.octo.avenger.core.db.model.DBRole;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public class RoleDAO extends BasicDAO<DBRole> implements IRolesDAO {

	public long createRole(DBRole role) throws DAOException {
		persistObject(role);
		return 0;
	}

	public DBRole getByName(String name) {
		final EntityManager entityManager = getEntityManager();
		final DBRole result = entityManager.find(DBRole.class, name);
		entityManager.close();
		return result;
	}

}
