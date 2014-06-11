package com.finna.be.octo.avenger.core.db.dao;

import java.util.List;

import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public interface IUserDAO {
	
	public long createUser(DBUser user) throws DAOException; 
	
	public DBUser getById(long id);

	public List<DBUser> getUsers();

	public DBUser getByUsername(String username);

	public void updateUser(DBUser user) throws DAOException;
	
}
