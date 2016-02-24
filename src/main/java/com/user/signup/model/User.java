package com.user.signup.model;

import org.springframework.stereotype.Component;

@Component 
public class User {
	
	
	private String userName;   
	private String dob;
	
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	} 

}
