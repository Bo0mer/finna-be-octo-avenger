package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.List;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public class UserDAO extends BasicDAO<DBUser> implements IUserDAO {

	private static final String SELECT_ALL_USERS = "SELECT u FROM USERS u";

	public long createUser(DBUser user) throws DAOException {
		persistObject(user);
		return user.getId();
	}

	public DBUser getById(long id) {
		return findById(DBUser.class, id);
	}

	public List<DBUser> getUsers() {
		return getQueryResult(SELECT_ALL_USERS, DBUser.class);

	}

}
