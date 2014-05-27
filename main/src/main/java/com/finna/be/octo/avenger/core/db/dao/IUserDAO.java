package com.finna.be.octo.avenger.core.db.dao;

import com.finna.be.octo.avenger.core.db.model.DBUser;

public interface IUserDAO {
	
	public long addUser(DBUser user); 
	
	public DBUser getUserById(long id);

}
