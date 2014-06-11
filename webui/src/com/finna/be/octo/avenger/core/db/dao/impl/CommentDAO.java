package com.finna.be.octo.avenger.core.db.dao.impl;

import java.util.Collection;

import com.finna.be.octo.avenger.core.db.dao.ICommentDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBComment;

public class CommentDAO extends BasicDAO<DBComment> implements ICommentDAO {

	private static final String SELECT_COMMENTS_WITH_TASK_ID = "SELECT c FROM COMMENTS c WHERE c.task.id = %s ORDER BY c.timestamp";

	@Override
	public DBComment getById(long id) {
		return findById(DBComment.class, id);
	}

	@Override
	public Collection<DBComment> getCommentsWithTaskId(long taskId) {
		return getQueryResult(String.format(SELECT_COMMENTS_WITH_TASK_ID, taskId),
				DBComment.class);
	}

	@Override
	public long createComment(DBComment comment) throws DAOException {
		persistObject(comment);
		return comment.getId();
	}

}
