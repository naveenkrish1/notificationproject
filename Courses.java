package com.students.courses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.students.ConnectionEstablishment;

import org.json.simple.JSONObject; 


public class Courses {
	public  boolean registercourses(String username,String courseid,String coursename) throws SQLException {
		Connection connection = new ConnectionEstablishment().createConnection();
		try {
			try {
				String sql = "SELECT courseid FROM REGISTEREDCOURSES where username =?";
				PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
				statement.setString(1,username);
				ResultSet result = statement.executeQuery();
				while(result.next()) {
					String s=result.getString("courseid");
					if(s.equals(courseid)) {
						return false;
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
			String sql1 = "INSERT INTO REGISTEREDCOURSES(username,courseid,coursename)"+"values(?,?,?)";
			PreparedStatement statement1 = ((java.sql.Connection) connection).prepareStatement(sql1);
			statement1.setString(1,username);
			statement1.setString(2,courseid);
			statement1.setString(3,coursename);
			statement1.executeUpdate();
			String sqll="INSERT INTO NOTIFICATIONS(username,notification)"+"values(?,?)";
			PreparedStatement statement4 = ((java.sql.Connection) connection).prepareStatement(sqll);
			statement4.setString(1,username);
			String notification=" new course registered successully";
			statement4.setString(2, notification);
			statement4.executeUpdate();
			return true;
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
		connection.close();
		return false;
	}
	@SuppressWarnings("unchecked")
	public  JSONObject getCourses(String username) throws SQLException {
		Connection connection = new ConnectionEstablishment().createConnection();
		String sql="SELECT * FROM REGISTEREDCOURSES WHERE username=?";
		PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
		statement.setString(1,username);
		ResultSet result = statement.executeQuery();
		JSONObject item1 =new JSONObject();
		while(result.next()) {
			String s=result.getString("courseid");
			String s1=result.getString("coursename");
			item1.put(s,s1);
		}
		
		return item1;
	}
	
	public  boolean createNewCourses(String courseid, String coursename) throws ClassNotFoundException, SQLException
	{
		Connection connection = new ConnectionEstablishment().createConnection();
		try {
			try {
				String sql = "SELECT courseid FROM COURSE where courseid =?";
				PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
				statement.setString(1,courseid);
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
			String sql1 = "INSERT INTO COURSE(courseid,cousename)"+"values(?,?)";
			PreparedStatement statement1 = ((java.sql.Connection) connection).prepareStatement(sql1);
			statement1.setString(1,courseid);
			statement1.setString(2,coursename);
			statement1.executeUpdate();
			String sqll="SELECT username from USER";
			PreparedStatement statement4 = ((java.sql.Connection) connection).prepareStatement(sqll);
			ResultSet result = statement4.executeQuery();
			while(result.next()) {
				String usernamee=result.getString("username");
				String sql2="INSERT INTO NOTIFICATIONS(username,notification)"+"VALUES(?,?)";
				PreparedStatement statement2 = ((java.sql.Connection) connection).prepareStatement(sql2);
				statement2.setString(1, usernamee);
				String notification="new course "+courseid+"available";
				statement2.setString(2,notification);
				statement2.executeUpdate();
			}
			return true;
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
		connection.close();
		return false;
	}

}
