package com.students.login.copy;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class LogIn {
	@ResponseBody
	@RequestMapping("/login")
	public void login(String username,String password,HttpSession session) throws ClassNotFoundException, SQLException {
		StudentLogIn logi=new StudentLogIn();
		boolean ischeck=logi.checkLogin(username, password);
		session.setAttribute("log",ischeck);
		
	}
}
