package com.finna.be.octo.avenger.core.db.dao;

import com.finna.be.octo.avenger.core.db.model.DBRole;
import com.finna.be.octo.avenger.dao.exceptions.DAOException;

public interface IRolesDAO {

	public long createRole(DBRole role) throws DAOException;

	public DBRole getByName(String name);

}
