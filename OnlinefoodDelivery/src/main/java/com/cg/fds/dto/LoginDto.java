package com.cg.fds.dto;

public class LoginDto {
	
	private String userId;
	private String userName;
	private String password;
	private boolean isLoggedIn;
	private String role;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String useId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}

				
}
