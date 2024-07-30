package com.graymatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DBConnection {

	static String url;
	static String uname;
	static String password;
	
	
	public DBConnection() {
		super();
	}

	public DBConnection(String url, String uname, String password) {
		super();
		this.url = url;
		this.uname = uname;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		
		DBConnection dbcon = (DBConnection)obj;
		return this.uname.equals(dbcon.getUname())
				&& this.url.equals(dbcon.getUrl()) 
				&& this.password.equals(dbcon.getPassword());
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(url, uname, password);
	}
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, password);
		
		
		return con;
		
	}
}
