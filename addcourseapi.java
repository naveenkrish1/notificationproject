package com.students.courses;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class addcourseapi {
	@ResponseBody
	@RequestMapping("/allcourses")
	public void addcourse(@RequestParam("courseid")String courseid,@RequestParam("coursename")String coursename,HttpSession session) throws ClassNotFoundException, SQLException {
		Courses course=new Courses();
		boolean isadded=course.createNewCourses(courseid,coursename);
		session.setAttribute("log",isadded);
	}
}