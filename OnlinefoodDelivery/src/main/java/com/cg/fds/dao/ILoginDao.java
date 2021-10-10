package com.cg.fds.dao;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.fds.entity.Login;
import org.springframework.stereotype.Repository;


@Repository

public interface ILoginDao extends JpaRepository<Login , String> {         


	
	Login save(Optional<Login> login);
	List<Login> findAll();
	Optional<Login> findById(String userId);  	
	
	@Query(value="select * from login where user_id=:name", nativeQuery=true)
	Optional<Login> findByUserName(@Param("name")String userName);

}









