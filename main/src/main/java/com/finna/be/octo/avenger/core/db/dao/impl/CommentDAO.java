package com.finna.be.octo.avenger.core.db.dao.impl;

import com.finna.be.octo.avenger.core.db.dao.ICommentDAO;
import com.finna.be.octo.avenger.core.db.model.DBComment;

public class CommentDAO extends BasicDAO<DBComment> implements ICommentDAO {

	public DBComment getById(long id) {
		return findById(DBComment.class, id);
	}


	
	
}
