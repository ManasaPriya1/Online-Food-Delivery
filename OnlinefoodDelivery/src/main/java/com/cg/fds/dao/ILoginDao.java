package com.cg.fds.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fds.entity.Login;
import org.springframework.stereotype.Repository;


@Repository

public interface ILoginDao extends JpaRepository<Login , String> {          //Integer - String


	//Login findByUsername(String username);

	Login save(Optional<Login> login);

	List<Login> findAll();

	//<Login> findByEmail(String email);

	Optional<Login> findByUserName(String userName);

	Optional<Login> findById(String userId);  //id to userId

	 
}









