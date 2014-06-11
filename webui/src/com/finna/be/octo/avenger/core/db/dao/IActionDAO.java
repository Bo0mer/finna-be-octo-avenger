package com.finna.be.octo.avenger.core.db.dao;

import java.util.Collection;

import com.finna.be.octo.avenger.core.db.dao.exceptions.DAOException;
import com.finna.be.octo.avenger.core.db.model.DBAction;

public interface IActionDAO {
	
	public long createAction(DBAction action) throws DAOException;

	public Collection<DBAction> getFilteredTaskActions(int rollbackDays);

}
