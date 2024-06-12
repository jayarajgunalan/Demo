package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {
	public static Connection getDBConnection() throws Exception
	{
		String url
			= "jdbc:mysql://XX.XX.XX.XX:XXXX/DDDD"; // table details
		String username = "XXXX"; // MySQL credentials
		String password = "XXXX";
		
		Class.forName(
			"com.mysql.cj.jdbc.Driver"); // Driver name
		
		Connection con = DriverManager.getConnection(
			url, username, password);
		
		return con;
		
	}
}

