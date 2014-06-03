package com.finna.be.octo.avenger.db.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.finna.be.octo.avenger.core.db.model.DBComment;

@Stateless
@LocalBean
public class CommentBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	public DBComment getCommentById(long id) {
		return entityManager.find(DBComment.class, id);
	}
	
	public long addComment(DBComment comment) {
		entityManager.persist(comment);
		entityManager.flush();
		entityManager.merge(comment.getAuthor());
		entityManager.merge(comment.getTask());
		entityManager.flush();
		return comment.getId();
	}
}
