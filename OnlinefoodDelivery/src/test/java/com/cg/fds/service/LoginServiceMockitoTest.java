package com.cg.fds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.fds.dao.ILoginDao;
import com.cg.fds.entity.Login;
import com.cg.fds.exception.LoginNotFoundException;

@ExtendWith(SpringExtension.class)

public class LoginServiceMockitoTest {
	
	// @InjectMock - Creates instance of a class and injects mocks that are created
		// with @Mock

		@InjectMocks
		LoginServiceImpl loginService;

		// @MockBean - Creates Mock of a class or interface

		@MockBean
		ILoginDao loginDao;

		// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
		@Test
		void testGetLoginByUserId() throws LoginNotFoundException {
			
			Login login = new Login("harsh@gmail.com", "Harsh", "Harsh1234");
			Mockito.when(loginDao.findById("harsh@gmail.com")).thenReturn(Optional.of(login));
			Login l= loginService.getLoginById("harsh@gmail.com");
			assertEquals("harsh@gmail.com", l.getUserid());
			assertEquals("Harsh", l.getUserName());
		}
		@Test
		void testGetAllLogin() {
			Login l1 = new Login("madhura@gmail.com", "madhura12", "smadhu123");
			Login l2 = new Login("manasa2@gmail.com",  "manasa12", "manasa23");
			List<Login> loginList = new ArrayList<>();
			loginList.add(l1);
			loginList.add(l2);
			Mockito.when(loginDao.findAll()).thenReturn(loginList);
			List<Login> login = loginService.getAllLogin();
			assertEquals(2, login.size());
			assertEquals("madhura@gmail.com", login.get(0).getUserid());
			assertEquals("madhura12", login.get(0).getUserName());
			assertEquals("manasa2@gmail.com", login.get(1).getUserid());
			assertEquals("manasa12", login.get(1).getUserName());
		}  
		@Test
		void testAddLogin() {
			Login login = new Login("seemapapu2@gmail.com", "seema12", "seema34");
			Mockito.when(loginDao.save(login)).thenReturn(login);
			Login newLogin = loginService.addLogin(login);
			assertEquals("seemapapu2@gmail.com", newLogin.getUserid());
			assertEquals("seema12", newLogin.getUserName());
		}  
		
}	


