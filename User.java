package com.students;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String username;
    
	private String password; 

	public String getRegisterNumber() {
		return username;
	}

	public void setRegisterNumber(String id) {
		this.username = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
