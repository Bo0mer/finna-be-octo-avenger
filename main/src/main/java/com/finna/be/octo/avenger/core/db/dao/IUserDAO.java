package com.finna.be.octo.avenger.core.db.dao;

import java.util.List;

import com.finna.be.octo.avenger.core.db.model.DBUser;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public interface IUserDAO {
	
	public long createUser(DBUser user) throws DAOException; 
	
	public DBUser getById(long id);

	public List<DBUser> getUsers();
	
}
