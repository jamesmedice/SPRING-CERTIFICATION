package com.medici.app.spring.java.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

public class BaseDAO {

	private DataSource ds;

	private Connection connection = null;

	// Input DataSource object in the DAO constructure.
	public BaseDAO(DataSource dataSource) {
		this.ds = dataSource;
	}

	// Get the database connection object.
	private Connection getDatabaseConnection() {
		if (connection == null) {
			try {
				connection = this.ds.getConnection();

				// Manually commit database submit.
				connection.setAutoCommit(false);

			} catch (SQLException ex) {
			}
		}

		return connection;
	}

	public String getDatabaseMetaData() {
		List<String> data = new ArrayList<String>();
		try {

			DatabaseMetaData dbmd = getDatabaseConnection().getMetaData();
			String[] types = { "TABLE" };
			ResultSet rs = dbmd.getTables(null, null, "%", types);
			while (rs.next()) {
				data.add(rs.getString("TABLE_NAME"));
			}

			return Arrays.toString(data.toArray());
			
		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
	}

}
