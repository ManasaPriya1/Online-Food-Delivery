package com.cg.fds.controller;



import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fds.entity.OrderDetails;
import com.cg.fds.exception.OrderDetailsNotFoundException;
import com.cg.fds.service.IOrderDetailsService;
import com.cg.fds.dto.OrderDetailsDto;
@RestController
public class OrderDetailsController {

	@Autowired
	IOrderDetailsService orderService;
	
	//view order
      @GetMapping("/order")
	  ResponseEntity <List<OrderDetails>> viewOrder()
	   {
		  return new ResponseEntity<>(orderService.viewOrder(),HttpStatus.OK);
	  }

	//add order
	@PostMapping("/addorder")
	ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order) {
	
		OrderDetails std = orderService.addOrder(order);
		return new ResponseEntity<>(std, HttpStatus.CREATED); // 201 created
	}
	//delete order
	@DeleteMapping("/deleteorder/{orderId}")
    ResponseEntity<OrderDetails> removeOrder(@PathVariable ("orderId")int orderId ) throws OrderDetailsNotFoundException
    {
	  OrderDetails ord =orderService.removeOrder(orderId);
   	   return new ResponseEntity<>(ord,HttpStatus.OK);
     } 
	 
	//update order
	@PutMapping("/order/update/{orderId}")
	ResponseEntity<OrderDetails> updateOrder(@PathVariable("orderId") int id , @RequestBody OrderDetails order)
	{
		OrderDetails ord=orderService.updateOrder(id,order);
		 return new ResponseEntity<>(ord,HttpStatus.OK);
	}
/*	@PostMapping("/order/totalCost")
	public ResponseEntity<order> create(@RequestBody Order form) {
		List<OrderDetailsDto> formDtos = form.getOrderDetails();
		return new ResponseEntity<>(order, HttpStatus.CREATED); //201 CREATED
	}
*/

	/*@GetMapping("/order/{customerId}")
	   ResponseEntity<OrderDetails> viewAllOrders(@PathVariable("customerId") int  customerId)
	   {
		OrderDetails order=orderService.viewAllOrders(customerId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	  }
	  */
}
