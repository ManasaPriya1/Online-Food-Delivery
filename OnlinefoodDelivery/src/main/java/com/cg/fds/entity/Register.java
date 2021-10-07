package com.cg.fds.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.Table;

@Entity
@Table(name ="register")


public class Register {
	//fields
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	//Constructors
	
	public Register() {
		
	}
	public Register(String userName, String password) {
		super();
		this.userId =userId;
		this.userName = userName;
		this.password = password;
	}
	public String getUserid() {
		return userId;
	}
	public void setUserid(String userid) {
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
	
	@Override
	public String toString() {
		return "Register [userid=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}


