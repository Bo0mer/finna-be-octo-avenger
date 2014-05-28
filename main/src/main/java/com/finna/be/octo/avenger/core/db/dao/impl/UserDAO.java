package com.finna.be.octo.avenger.core.db.dao.impl;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class UserDAO extends BasicDAO<DBUser> implements IUserDAO {

	public long createUser(DBUser user) {
		persistObject(user);
		return user.getId();
	}

	public DBUser getById(long id) {
		return findById(DBUser.class, id);
	}
	
}
