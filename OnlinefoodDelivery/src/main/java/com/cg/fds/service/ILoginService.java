package com.cg.fds.service;

import java.util.List;




import com.cg.fds.dto.LoginDto;
import com.cg.fds.entity.Login;
import com.cg.fds.exception.InvalidCredentialsException;
import com.cg.fds.exception.LoginNotFoundException;

public interface ILoginService {
	List<Login>getAllLogin();
	Login getLoginById(int id) throws LoginNotFoundException;
	Login addLogin(Login login);
	LoginDto Login(Login login);
	LoginDto login(com.cg.fds.entity.Login login) throws LoginNotFoundException, InvalidCredentialsException;
	//public LoginDto logout(String userName) throws LoginNotFoundException;
	public LoginDto logout(com.cg.fds.entity.Login login) throws LoginNotFoundException;
	com.cg.fds.entity.Login getLoginById(String id) throws LoginNotFoundException;
	LoginDto logout(String userName) throws LoginNotFoundException;
	
}
