package com.trinh.bookmanager.models;

import java.sql.Connection;

public interface IConnectionBehavior {
	Connection getConnection();

	String getConnectionURL();

	String getConnectionDetails();

	String getTablesSchemaQuery();
}