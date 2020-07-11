package com.students.courses;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class registercourseapi {
	@ResponseBody
	@RequestMapping("/registercourse")
	public void registercourse(@RequestParam("username")String username,@RequestParam("courseid")String courseid,@RequestParam("coursename")String coursename,HttpSession session) throws ClassNotFoundException, SQLException {
		Courses course=new Courses();
		boolean isregistered=course.registercourses(username,courseid,coursename);
		session.setAttribute("registercourse",isregistered);
	}
}