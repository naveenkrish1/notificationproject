package com.students.courses;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getcourseapi {
	@ResponseBody
	@RequestMapping("/allcourses")
	public void GetCourses(@RequestParam("username")String username,HttpSession session) throws ClassNotFoundException, SQLException {
		Courses course=new Courses();
        JSONObject item=new JSONObject();
        item=course.getCourses(username);
		session.setAttribute("registeredcourses",item);

	}
}
