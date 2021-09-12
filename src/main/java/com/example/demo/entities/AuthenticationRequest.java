package com.example.demo.entities;

public class AuthenticationRequest {
	private String userName;
	private String password;
	
	public AuthenticationRequest(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	
	public String getUsername() {
		return userName;
	}
	
	public void setUserName(String username) {
		this.userName = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
