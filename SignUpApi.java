package com.students.signup;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpApi {
	@ResponseBody
	@RequestMapping("/register")
	public void login(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session) throws ClassNotFoundException, SQLException {
		NewStudent student=new NewStudent();
		boolean isadded=student.createNewStudent(username, password);
		session.setAttribute("register",isadded);
	}
}