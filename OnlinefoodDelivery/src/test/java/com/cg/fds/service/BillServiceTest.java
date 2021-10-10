
package com.cg.fds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fds.entity.Bill;
import com.cg.fds.exception.BillNotFoundException;


@SpringBootTest
public class BillServiceTest {

	@Autowired
	IBillService billService;

	@Test
	@Disabled
	void testGetAllBill() {
		
		//Object billService;
		List<Bill>	 bill  = billService.getAllBill();
		assertEquals(9, bill.size());  //counting 
		assertEquals(3,  bill.get(0).getBillId());
		assertEquals(LocalDateTime.of(2021,10,6,11,43,39,284), bill.get(0).getBillDate());
		assertEquals(200, bill.get(0).getTotalCost());
		assertEquals(2, bill.get(0).getTotalItem());
		}
	@Test
	//@Disabled
	void testGetBillByBillId() throws BillNotFoundException  {
		Bill bill = billService.getBillById(3);
	
		assertEquals(3, bill.getBillId());	
	} 
	@Test
	@Disabled
	void testAddBill() {
		
		Bill bill = new Bill(1, LocalDateTime.of(2021,10,10,10,28,29,455), 300,5);
		Bill newBill= billService.addBill(bill);
		assertEquals(1, newBill.getBillId());
		assertEquals(LocalDateTime.of(2021,10,10,10,28,29,455), newBill.getBillDate());
		assertEquals(300, newBill.getTotalCost());
		assertEquals(5, newBill.getTotalItem());
		 
		} 
	@Test
	@Disabled
	void testRemoveBill() {
		Bill bill = billService.removeBill(0);
		assertEquals(0, bill.getBillId());
	}
	@Test
	@Disabled
	void testViewBills() {
		List<Bill> bill = billService.viewBills();
		assertEquals(4,bill.get(1).getBillId());
		assertEquals(LocalDateTime.of(2021, 10,3,8,23,32,482), bill.get(1).getBillDate());
		assertEquals(1000, bill.get(1).getTotalCost());
		assertEquals(5,bill.get(1).getTotalItem());
	}
	


	
}
 
