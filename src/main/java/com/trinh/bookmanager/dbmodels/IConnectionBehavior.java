package com.trinh.bookmanager.dbmodels;

import java.sql.Connection;

public interface IConnectionBehavior {
	Connection getConnection();

	String getConnectionURL();

	String getConnectionDetails();

	String getTablesSchemaQuery();
}