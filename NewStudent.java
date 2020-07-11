package com.students.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.students.ConnectionEstablishment;

public class NewStudent {


	public  boolean createNewStudent(String username, String password) throws ClassNotFoundException, SQLException
	{
		Connection connection = new ConnectionEstablishment().createConnection();
		try {
			try {
				String sql = "SELECT username FROM USER where username =?";
				PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
				statement.setString(1,username);
				ResultSet result = statement.executeQuery();
				if(result.next()) {
					return false;
				}
				result.close();

			}catch(SQLException sql) {
				sql.printStackTrace();

			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			String sql1 = "INSERT INTO USER(username,password)"+"values(?,?)";
			PreparedStatement statement1 = ((java.sql.Connection) connection).prepareStatement(sql1);
			statement1.setString(1,username);
			statement1.setString(2,password);
			statement1.executeUpdate();
			return true;
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
		connection.close();
		return false;
	}

	public static void main(String []args) throws ClassNotFoundException, SQLException {
		NewStudent ne=new NewStudent();
		boolean isadded=ne.createNewStudent("ujj", "uuuu");
		System.out.println(isadded);
		
	}
}
