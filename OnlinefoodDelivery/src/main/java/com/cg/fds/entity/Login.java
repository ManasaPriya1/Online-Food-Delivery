package com.cg.fds.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

	@Entity
	@Table(name ="login")

	public class Login {
		
		//fields
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="user_id", unique = true, length =50, nullable = false) // added this line
		
		@NotEmpty(message = "Please enter userId")
		//@Size(min=3, message="userid should have atleast 3 char")
		private String userId;   //changed both int to string and userid to userId
		
		@Column(name="user_name", unique = true, length = 50, nullable = false)
		@NotEmpty
		@Size(min=3, message=" username should have atleast 3 char")
		private String userName;
		
		@Column(name="password" , unique = true, length =50, nullable = false)
		@NotEmpty
		@Size(min=8, message="password should have atleast 3 char")
		private String password;
		
		//Constructors
		
		public Login() {
			
		}
		public Login(String userId, String userName, String password) {
			
			super();
			this.userId=userId;  //added this line
			this.userName = userName;
			this.password = password;
		}
		public String getUserid() {    //int to string 
			return userId;             //userid to userId
		}
		public void setUserid(String userid) {  // i - s
			this.userId = userid;               //id to Id
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
	//	public String getEmail() {
			
		//	return null;
		//}
		public void setLoggedIn(boolean b) {
					}
				
		
		
	}


