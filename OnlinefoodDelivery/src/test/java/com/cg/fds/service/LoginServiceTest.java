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

	@Autowired
	ILoginService loginService;
	
	@Test
	void testGetAllLogin() {
		List<Login>	 login  = loginService.getAllLogin();
		assertEquals(12, login.size());  //counting 
		assertEquals("manasa12",  login.get(1).getUserName());
		assertEquals("manasa2@gmail.com", login.get(1).getUserid());
		assertEquals("manasa23", login.get(1).getPassword());
		}
	@Test
	@Disabled
	void testGetLoginByUserId() throws LoginNotFoundException  {
		Login login = loginService.getLoginById("sumaj@gmail.com");
	
		assertEquals("sumaj@gmail.com", login.getUserid());	
	} 
	
	@Test
	@Disabled
	void testAddLogin() {
		
		Login login = new Login("monusha@gmail.com", "Monusha", "Monusha234");
		Login	newLogin= loginService.addLogin(login);
		assertEquals("monusha@gmail.com" , newLogin.getUserid());
		assertEquals("Monusha", newLogin.getUserName());
		assertEquals("Monusha234", newLogin.getPassword());
		} 
		@Test
		@Disabled
		void testLogin() {
			Login login = new Login("pranusri@gmail.com", "Pranusri", "Pranu123");
			LoginDto newLogin = loginService.Login(login);
			assertEquals("pranusri@gmail.com", login.getUserid());
     		}    
}
