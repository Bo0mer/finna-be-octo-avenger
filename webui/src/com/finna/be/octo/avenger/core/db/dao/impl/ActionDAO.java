package com.finna.be.octo.avenger.core.db.dao.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;

import com.finna.be.octo.avenger.core.db.dao.IActionDAO;
import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBAction;

public class ActionDAO extends BasicDAO<DBAction> implements IActionDAO {

	private static final String GET_ACTIONS_WITH_ROLLBACK = "SELECT a FROM ACTIONS a WHERE a.performedAt > :param ORDER BY a.performedAt DESC";
	
	@Override
	public long createAction(DBAction action) throws DAOException {
		persistObject(action);
		return action.getId();
	}

	@Override
	public Collection<DBAction> getFilteredTaskActions(int rollbackDays) {
		final EntityManager entitiyManager = getEntityManager();
		final TypedQuery<DBAction> query = entitiyManager.createQuery(GET_ACTIONS_WITH_ROLLBACK, DBAction.class);
		final ParameterExpression<Timestamp> param = entitiyManager.getCriteriaBuilder().parameter(Timestamp.class, "param");
		query.setParameter(param, substractDays(rollbackDays));
		return query.getResultList();
	}
	
	private Timestamp substractDays(int days) {
		Timestamp now = new Timestamp((new Date()).getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, (-1 * days));
		return new Timestamp(calendar.getTime().getTime());
	}

}
