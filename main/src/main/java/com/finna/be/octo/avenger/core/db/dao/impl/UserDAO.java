package com.finna.be.octo.avenger.core.db.dao.impl;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public class UserDAO extends BasicDAO<DBUser> implements IUserDAO {

	public long createUser(DBUser user) throws DAOException {
		persistObject(user);
		return user.getId();
	}

	public DBUser getById(long id) {
		return findById(DBUser.class, id);
	}
	
}
