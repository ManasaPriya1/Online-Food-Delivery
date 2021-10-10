package com.cg.fds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fds.dto.LoginDto;
import com.cg.fds.entity.Login;
import com.cg.fds.exception.LoginNotFoundException;
@SpringBootTest
public class LoginServiceTest {

	private static final Login login = null;
	@Autowired
	ILoginService loginService;
	
	@Test
	void testGetAllLogin() {
		List<Login>	 login  = loginService.getAllLogin();
		assertEquals(8, login.size());  //counting 
		assertEquals("ManasaPriya",  login.get(1).getUserName());
		assertEquals("priya.manasa@gmail.com", login.get(1).getUserid());
		assertEquals("Manasa123", login.get(1).getPassword());
		assertEquals("Customer", login.get(1).getRole());

		}
	@Test
	@Disabled
	void testGetLoginByUserId() throws LoginNotFoundException  {
		Login login = loginService.getLoginById("abc@gmail.com");
		assertEquals("abc@gmail.com", login.getUserid());	
	} 
	
	@Test
	@Disabled
	void testAddLogin() {
		
		Login login = new Login("hemalatha@gmail.com", "HemaLatha", "Hemapapu1"," Customer");
		Login	newLogin= loginService.addLogin(login);
		assertEquals("hemalatha@gmail.com" , newLogin.getUserid());
		assertEquals("HemaLatha", newLogin.getUserName());
		assertEquals("Hemapapu1", newLogin.getPassword());
		assertEquals("Customer", newLogin.getRole());
		} 
		@Test
		@Disabled
		void testLogin() {
			
			Login login = new Login("madhurya@gmail.com", "Madhurya", "Madhurya23", "Customer");
			LoginDto Login = loginService.Login(login);
			assertEquals("madhurya@gmail.com", login.getUserid());
		    assertEquals("Madhurya", login.getUserName());	
     		}
		@Test
		@Disabled
		void testLogout() {
		Login login = new Login("madhurya@gmail.com", "Madhurya", "Madhurya23", "Customer");
		LoginDto Logout = loginService.Login(login);
		assertEquals("madhurya@gmail.com", login.getUserid());
		assertEquals("Madhurya", login.getUserName());	
     		}    
		
	}
