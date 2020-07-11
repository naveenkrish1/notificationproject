package com.students.notification;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller
public class NotificationApi{
	@ResponseBody
	@RequestMapping("/notifycourses")
	public void GetNotifications(@RequestParam("username")String username,HttpSession session) throws ClassNotFoundException, SQLException {
		NotifyCourses notify=new NotifyCourses();
        JSONObject item=new JSONObject();
        item=notify.GetNotifications(username);
		session.setAttribute("notifications",item);

	}
}