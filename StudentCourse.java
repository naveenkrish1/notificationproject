package com.students;

import org.springframework.stereotype.Component;

@Component
public class StudentCourse {
	
	String  username;
	
	String  courseid;
	
	String coursename;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	

	
}
