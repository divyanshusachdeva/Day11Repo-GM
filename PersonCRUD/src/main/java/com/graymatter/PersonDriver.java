package com.graymatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDriver {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/graymatterdb";
		String username = "root";
		String password = "password";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}
	
	
	


	
}
