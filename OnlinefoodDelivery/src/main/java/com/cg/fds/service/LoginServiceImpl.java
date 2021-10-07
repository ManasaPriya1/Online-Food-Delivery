package com.cg.fds.service;

import java.util.List;
import java.util.Optional;
/*
import org.apache.logging.log4j.LogManager;
/*
import org.hibernate.internal.log.UnsupportedLogger_.logger; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.dao.ILoginDao;
import com.cg.fds.dto.LoginDto;
import com.cg.fds.entity.Login;
import com.cg.fds.exception.InvalidCredentialsException;
import com.cg.fds.exception.LoginFoundException;
import com.cg.fds.exception.LoginNotFoundException;

@Service
public  class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginDao loginDao;
/*
	private static Logger Logger = LogManager.getLogger(); */

	@Override
	public List<Login> getAllLogin() {
		return loginDao.findAll();
	}

	@Override
	public Login getLoginById(String id) throws LoginNotFoundException {    // int - String
		Optional<Login> login = loginDao.findById(id);               //findById(id);
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
	public LoginDto login(Login login) throws LoginNotFoundException, InvalidCredentialsException {
		Optional<Login> dbLogin = loginDao.findByUserName(login.getUserName());
		if (!dbLogin.isPresent()) {
			throw new LoginFoundException("Customer not found with given userName " + login.getUserName());
		}

		Login l = dbLogin.get();
		LoginDto loginDto = new LoginDto();

		if (login.getPassword().equals(l.getPassword()) && login.getUserName().equals(l.getUserName())) {

			l.setLoggedIn(true);
			loginDao.save(l);
			loginDto.setUserName(l.getUserName());
			loginDto.setLoggedIn(true);
		} else {
			throw new InvalidCredentialsException("Invalid credentials");
		}

		return loginDto;
	}

	@Override
	public LoginDto logout(String userName) throws LoginNotFoundException {
		Optional<Login> dbLogin = loginDao.findByUserName(userName);
		if (!dbLogin.isPresent()) {
			throw new LoginNotFoundException("Customer not found with given userName " + userName);
		}
		Login l = dbLogin.get();
		LoginDto loginDto = new LoginDto();

		l.setLoggedIn(false);  
		loginDao.save(l);
		loginDto.setLoggedIn(false);

		return loginDto;
	}

	@Override
	
	public com.cg.fds.entity.Login getLoginById(int id) throws LoginNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginDto Login(com.cg.fds.entity.Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginDto logout(com.cg.fds.entity.Login login) throws LoginNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public LoginDto Login(com.cg.fds.entity.Login login) {
		// TODO Auto-generated method stub
		return null;
	} */

/*	@Override
	public com.cg.fds.entity.Login getLoginById(String id) throws LoginNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}   */
}
