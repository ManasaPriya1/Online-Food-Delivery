package com.cg.fds.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.*;

	@Entity
	@Table(name ="login")

	public class Login {
		
		//fields
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="user_id", unique = true, length =50, nullable = false) 
		@NotEmpty(message = "Please enter userId")
		private String userId;   
		
		@Column(name="user_name", unique = true, length = 50, nullable = false)
		@NotEmpty(message =" Please enter a username")
		private String userName;
		
		@NotEmpty(message = "please enter your password")
		@Size(min=3, message="password should have atleast 3 char")
		private String password;
		
		@Column(name ="role")
		@NotEmpty(message ="please enter your role")
		private String role;
		
		//Constructors
		
		public Login() {
			
		}
		public Login(String userId, String userName, String password, String role) {
			
			super();
			this.userId=userId;  
			this.userName = userName;
			this.password = password;
			this.role=role; 
		}
		public String getUserid() {     
			return userId;            
		}
		public void setUserid(String userid) {  
			this.userId = userid;               
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
		public void setRole(String role) {
			this.role = role;
		}
		public String getRole() {
			return role;
		}
		public void setLoggedIn(boolean b) {
		}
				
			
	}


