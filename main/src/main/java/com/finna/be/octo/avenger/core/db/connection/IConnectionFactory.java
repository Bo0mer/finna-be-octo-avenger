package com.finna.be.octo.avenger.core.db.connection;

import java.sql.Connection;

public interface IConnectionFactory {
	
	public Connection createConnection();
	
}
