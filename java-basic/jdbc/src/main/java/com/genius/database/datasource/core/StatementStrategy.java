package com.genius.database.datasource.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

	PreparedStatement getPreparedStatement(Connection connection) throws SQLException;
}
