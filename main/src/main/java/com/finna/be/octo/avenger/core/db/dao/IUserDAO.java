package com.finna.be.octo.avenger.core.db.dao;

import com.finna.be.octo.avenger.core.db.model.DBUser;

public interface IUserDAO {
	
	public long createUser(DBUser user); 
	
	public DBUser getById(long id);

}
