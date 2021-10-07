package com.cg.fds.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fds.service.ILoginService;
import com.cg.fds.dto.LoginDto;
import com.cg.fds.entity.Login;
import com.cg.fds.exception.LoginNotFoundException;

@RestController
public class LoginController {

	@Autowired
	ILoginService loginService;
	
	private static Logger Logger = LogManager.getLogger();



	@GetMapping("/login")
	ResponseEntity<List<Login>> getAllLogin() {
		Logger.info("Sending request to service layer for getting customer");
		return new ResponseEntity<>(loginService.getAllLogin(), HttpStatus.OK); // 200 Ok
	}

	// Get Customer by user id -GET 
	@SuppressWarnings("unused")
	@GetMapping("/login/{loginId}")             
	ResponseEntity<List<Login>> getLoginById(@PathVariable("loginId") String userId) throws LoginNotFoundException {
		Logger.info("Sending request to service layer for get customer by id");

	Login login = loginService.getLoginById(userId);
	Logger.debug("Received  customer object  from service layer");
	Logger.info("Returning customer object");
		return new ResponseEntity<>(loginService.getAllLogin(), HttpStatus.OK); // 200 Ok
	}

	// Add new Customer - POST
	@PostMapping("/login/add")
	ResponseEntity<Login> addLogin(@Valid @RequestBody Login login) {
		Logger.info("Sending request to service layer to add new  customer ");
		Login l = loginService.addLogin(login);
		Logger.debug("Received customer object  from service layer");
		Logger.info("Returning customer object");
		return new ResponseEntity<>(l, HttpStatus.CREATED); // 201 CREATED
	}

	// login customer - POST
	@PostMapping("/login")
	ResponseEntity<LoginDto> Login(@RequestBody Login login) throws LoginNotFoundException {
		Logger.info("Sending request to service layer to login  customer ");
		LoginDto l = loginService.Login(login);
		Logger.debug("Received customer object  from service layer");
		Logger.info("Returning customer object");
		return new ResponseEntity<>(l, HttpStatus.OK); // 200 OK
	}
	// logout customer - PATCH
	 @PatchMapping("/logout")
	 ResponseEntity<LoginDto> logout(@RequestBody Login login)throws LoginNotFoundException {
		 Logger.info("Sending request to service layer to logout customer ");
		 LoginDto l= loginService.logout(login);
		 Logger.debug("Received customer object  from service layer");
		 Logger.info("Returning customer object");
		 return new ResponseEntity<>(l, HttpStatus.OK);
	}

}
