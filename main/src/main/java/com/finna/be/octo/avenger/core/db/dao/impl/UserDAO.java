package com.finna.be.octo.avenger.core.db.dao.impl;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class UserDAO extends BasicDAO implements IUserDAO {

	public long addUser(DBUser user) {
		persistObject(user);
		return user.getId();
	}

	public DBUser getUserById(long id) {
		DBUser user = entityManager.find(DBUser.class, id);
		return user;
	}
	
}