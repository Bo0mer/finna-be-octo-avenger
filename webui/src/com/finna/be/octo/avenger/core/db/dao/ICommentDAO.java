package com.finna.be.octo.avenger.core.db.dao;

import java.util.Collection;

import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBComment;

public interface ICommentDAO {

	public DBComment getById(long id);
	
	public Collection<DBComment> getCommentsWithTaskId(long taskId);
	
	public long createComment(DBComment comment) throws DAOException; ;
	
}
