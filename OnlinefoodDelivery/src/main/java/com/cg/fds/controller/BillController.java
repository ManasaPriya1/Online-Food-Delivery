package com.cg.fds.controller;

import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fds.entity.Bill;
import com.cg.fds.service.IBillService;
import com.cg.fds.service.IOrderDetailsService;

@RestController
public class BillController {
	@Autowired
	IBillService billService;

	@Autowired
	IOrderDetailsService orderDetailsService;

	private LocalDateTime billDate;
	private static Logger Logger = LogManager.getLogger();

	// View item
	@GetMapping("/bill")
	ResponseEntity<List<Bill>> getAllBill() {
		Logger.info("Sending request to service layer for getting the information about bill");
		return new ResponseEntity<>(billService.getAllBill(), HttpStatus.OK); // 200 OK
	}

	// add bill
	@PostMapping("/bill")
	ResponseEntity<Bill> addBill(@Valid @RequestBody Bill bill) {
		Logger.info("Sending request to service layer for getting the information to add a bill");
		Bill bil = billService.addBill(bill);
		Logger.debug("Received bill object  from service layer");
		Logger.info("Returning bill object");
		return new ResponseEntity<>(bil, HttpStatus.CREATED); // 201 CREATED
	}

	// update Bill
	@PutMapping("/bill/{billId}")
	ResponseEntity<Bill> updateItem(@PathVariable("billId") int billId, @RequestBody Bill bill) {
		Logger.info("Sending request to service layer for getting the information to update a bill");

		Bill bil = billService.updateBill(billId, bill);
		Logger.debug("Received  bill object  from service layer");
		Logger.info("Returning bill object");
		return new ResponseEntity<>(bil, HttpStatus.OK); // 200 OK
	}

	// remove Bill
	@DeleteMapping("/bill/{billId}")
	ResponseEntity<Bill> removeBill(@PathVariable("billId") int billId) {
		Logger.info("Sending request to service layer for getting the information to remove a bill");

		Bill bil = billService.removeBill(billId);
		Logger.debug("Received  bill object  from service layer");
		Logger.info("Returning bill object");

		return new ResponseEntity<>(bil, HttpStatus.OK); // 200 OK
	}

	// view Bill by Date
	@GetMapping("/bill/date/{billDate}")
	ResponseEntity<List<Bill>> viewBills(@PathVariable("billDate") @RequestParam("billDate") LocalDateTime billDate) {
		Logger.info("Sending request to service layer to view bill by date");
		List<Bill> bil = billService.viewBills(billDate);
		Logger.debug("Received  bill object response from service layer");
		Logger.info("Returning bill object");

		return new ResponseEntity<>(bil, HttpStatus.OK); // 200 OK
	}

	// view Bill by custId
	@GetMapping("/bill/id/{custId}")
	ResponseEntity<List<Bill>> viewBills(@PathVariable("custId") String custId) {
		Logger.info("Sending request to service layer for getting the information to view a bill");
		List<Bill> bill = billService.viewBills(custId);
		Logger.debug("Received  bill object  from service layer");
		Logger.info("Returning bill object");

		return new ResponseEntity<>(bill, HttpStatus.OK);
	}

	@GetMapping("/bill/totalCost")
	ResponseEntity<List<Bill>> createBills(@RequestBody Bill bill, LocalDateTime totalCost) {
		List<Bill> bil = billService.viewBills(totalCost);
		return new ResponseEntity<>(bil, HttpStatus.OK);
	}
/*
public int getTotalCost(List<CartItem> cartList) {
		int total = 0, count = 0;
		while (count < cartList.size()) {
			total = totalCost + (cartList.get(count).getQuantity() * cartList.get(count).getPrice());
			count++;
		}
		return total;
	}         */
	
}