package com.finna.be.octo.avenger.core.db.dao;

import com.finna.be.octo.avenger.core.db.model.DBComment;

public interface ICommentDAO {

	public DBComment getById(long id);
	
}
