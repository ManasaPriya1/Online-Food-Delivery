package com.cg.fds.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entity.OrderDetails;

@Repository
public interface IOrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

}