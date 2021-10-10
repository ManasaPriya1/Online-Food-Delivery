package com.cg.fds.service;

import java.util.List;

import com.cg.fds.entity.OrderDetails;
import com.cg.fds.exception.OrderDetailsNotFoundException;

public interface IOrderDetailsService {
	public OrderDetails addOrder(OrderDetails order);
	public OrderDetails updateOrder(int orderId,OrderDetails order);
	public OrderDetails deleteOrderById(int orderId) throws OrderDetailsNotFoundException ;
	public OrderDetails removeOrder(int orderId);
	public List<OrderDetails> viewOrder();

}