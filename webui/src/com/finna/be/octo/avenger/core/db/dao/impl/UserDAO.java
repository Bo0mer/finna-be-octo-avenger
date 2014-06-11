package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.List;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class UserDAO extends BasicDAO<DBUser> implements IUserDAO {

	private static final String SELECT_ALL_USERS = "SELECT u FROM USERS u";
	private static final String SELECT_USER_BY_USERNAME = "SELECT u FROM USERS u WHERE u.username LIKE '%s'";

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

	@Override
	public DBUser getByUsername(String username) {
		List<DBUser> users = getQueryResult(String.format(SELECT_USER_BY_USERNAME, username), DBUser.class);
		if (users.size() == 0 || users.size() > 1) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public void updateUser(DBUser user) throws DAOException {
		mergeObject(user);
	}

}
