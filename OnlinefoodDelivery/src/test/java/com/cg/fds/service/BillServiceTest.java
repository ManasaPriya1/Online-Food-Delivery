/*
package com.cg.fds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	void testGetAllBill() {
		
		//Object billService;
		List<Bill>	 bill  = billService.getAllBill();
		assertEquals(12, bill.size());  //counting 
		assertEquals("",  bill.get(1).getBillId());
		assertEquals("", bill.get(1).getBillDate());
		assertEquals("", bill.get(1).getBillOrder());
		}
	@Test
	@Disabled
	void testGetBillByBillId() throws BillNotFoundException  {
		Bill bill = billService.getBillById(0);
	
		assertEquals("0", bill.getBillId());	
	} 
	@Test
	@Disabled
	void testAddBill() {
		
		Bill bill = new Bill(0, null, 0, 0);
		Bill	newBill= billService.addBill(bill);
		assertEquals("monusha@gmail.com" , newBill.getBillId());
		assertEquals("Monusha", newBill.getBillId());
		//assertEquals("Monusha234", newLogin.getPassword());
		} 
	@Test
	//@Disabled
	void testRemoveBill() {
		Bill bill = billService.removeBill(0);
		assertEquals("", bill.getBillId());
	}
	@Test
	//@Disabled
	void testViewBills() {
		List<Bill> bill = billService.viewBills(null);
		assertEquals("", ((Bill) bill).getBillId());
		assertEquals("", bill.get(0));
	}
	


	
}
 
*/