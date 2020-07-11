package com.students.login.copy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.students.ConnectionEstablishment;



public class StudentLogIn {


	public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException
	{
		Connection connection = new ConnectionEstablishment().createConnection();
		try {
			String sql = "SELECT username,password FROM USER";
			PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);

			ResultSet result = statement.executeQuery();
			System.out.print(result);
			while(result.next()) {
				String uname=result.getString("username");
				String pass=result.getString("password");
				if(username.equals(uname)&& password.equals(pass)) {
					result.close();
					connection.close();
					return true;
				}
			}
			result.close();

		}catch(SQLException sql) {
			sql.printStackTrace();

		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		connection.close();
		return false;


	}
}
