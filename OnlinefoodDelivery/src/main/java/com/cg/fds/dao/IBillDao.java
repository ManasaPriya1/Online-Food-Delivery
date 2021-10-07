package com.cg.fds.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fds.entity.Bill;

public interface IBillDao extends JpaRepository<Bill, Integer> {

	
}
