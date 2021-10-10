package com.cg.fds.service;

import java.util.List;
import com.cg.fds.dto.LoginDto;
import com.cg.fds.entity.Login;
import com.cg.fds.exception.InvalidCredentialsException;
import com.cg.fds.exception.LoginNotFoundException;

public interface ILoginService {
	List<Login>getAllLogin();
	Login addLogin(Login login);
	LoginDto Login(Login login);
	LoginDto login(Login login) throws LoginNotFoundException;
	LoginDto logout(Login login) throws LoginNotFoundException;
	Login getLoginById(String id) throws LoginNotFoundException; 
	LoginDto logout(String userId) throws LoginNotFoundException;
	
}