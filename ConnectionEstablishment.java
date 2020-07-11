package com.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEstablishment {
	Connection conn = null;
	public Connection createConnection() {
		try{
			String jdbcURL = "jdbc:mysql://127.0.0.1:3306/mydb";
			String dbUser = "root";
			String dbPassword = "saravanan_17";
			System.out.print(dbUser);
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = (Connection) DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			//STEP 4: Execute a query
			return 	this.conn;
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}//end finally try
		System.out.println("Goodbye!");
		return conn;
	}
	
	// This is the method to close the existing connection
	public void closeConnection()
	{
		try
		{
			if(this.conn !=null)
			{
				this.conn.close();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
