package com.cg.fds.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.dao.ILoginDao;
import com.cg.fds.dto.LoginDto;
import com.cg.fds.entity.Login;
import com.cg.fds.exception.LoginFoundException;
import com.cg.fds.exception.LoginNotFoundException;

@Service
public  class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginDao loginDao;
	
	private static Logger logger = LogManager.getLogger();

	@Override
	public List<Login> getAllLogin() {
		return loginDao.findAll();
	}

	@Override
	public Login getLoginById(String id) throws LoginNotFoundException {   
		Optional<Login> login = loginDao.findById(id);               
		if (!login.isPresent()) {
			throw new LoginNotFoundException("Customer not found with given userid " + id);
		}
		return login.get();
	}

	@Override
	public Login addLogin(Login login) {
		Optional<Login> l = loginDao.findById(login.getUserid());
		if (l.isPresent()) {
			throw new LoginFoundException("Customer already exists with given userid " + login.getUserid());
		}
		return loginDao.save(login);
	}

	@Override
	public LoginDto login(Login login) throws  LoginNotFoundException {
		Optional<Login> dbLogin = loginDao.findById(login.getUserid());
		if (!dbLogin.isPresent()) {
			throw new LoginNotFoundException("Customer not found with given userId " + login.getUserid());
		}

		Login l = dbLogin.get();
		LoginDto loginDto = new LoginDto();

		if (login.getPassword().equals(l.getPassword()) && login.getUserName().equals(l.getUserName()) && login.getRole().equals(l.getRole())) {
			//set isLoggedIn flag to true
			l.setLoggedIn(true);
			loginDao.save(l);
			loginDto.setUserName(l.getUserName());
			loginDto.setUserId(l.getUserid());
			loginDto.setrole(l.getRole());
			loginDto.setLoggedIn(true);
			
			return loginDto;

			
		} else {
			throw new LoginNotFoundException("Invalid credentials");
		}

	}

	@Override
	public LoginDto logout(String userId) throws LoginNotFoundException {
		logger.info(userId);
		Optional<Login> dbLogin = loginDao.findById(userId);
		if (!dbLogin.isPresent()) {
			throw new LoginNotFoundException("Customer not found with given userId " + userId);
		}
		Login l = dbLogin.get();
		LoginDto loginDto = new LoginDto();

		l.setLoggedIn(false);  
		loginDao.save(l);
		loginDto.setLoggedIn(false);

		return loginDto;
	}

	@Override
	public LoginDto Login(com.cg.fds.entity.Login login) {
		
		return null;
	}

	@Override
	public LoginDto logout(com.cg.fds.entity.Login login) {

		return null;
	} 

	
}
