package com.students.notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.students.ConnectionEstablishment;
import org.json.simple.JSONObject; 


public class NotifyCourses {
	@SuppressWarnings("unchecked")
	public  JSONObject GetNotifications(String username) throws SQLException {
		Connection connection = new ConnectionEstablishment().createConnection();
		String sql="SELECT * FROM NOTIFICATIONS WHERE username= ?";
		PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
	    statement.setString(1, username);
	    statement.executeQuery();
	    ResultSet result = statement.executeQuery();
	    JSONObject item=new JSONObject();
	    while(result.next()) {
	    	String notify=result.getString("notification");
	    	String s=result.getString("status");
	    	item.put(notify,s);
	    }
	    result.close();
	    connection.close();
	    return item;
	}
	
}
