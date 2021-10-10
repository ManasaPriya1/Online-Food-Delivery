package com.cg.fds.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fds.entity.Bill;

public interface IBillDao extends JpaRepository<Bill, Integer> {

	void removeByBillId(int i);


	}
