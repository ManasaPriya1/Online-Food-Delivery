/* package com.cg.fds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.fds.dao.IBillDao;
import com.cg.fds.entity.Bill;
import com.cg.fds.exception.BillNotFoundException;

@ExtendWith(SpringExtension.class)

public class BillServiceMockitoTest {
	
	// @InjectMock - Creates instance of a class and injects mocks that are created
		// with @Mock

		@InjectMocks
		BillServiceImpl billService;

		// @MockBean - Creates Mock of a class or interface

		@MockBean
		IBillDao billDao;

		// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}                                    
		@Test
		void testGetBillByUserId() throws BillNotFoundException {
			
			Bill bill = new Bill(0, null, 0, 0);
			Mockito.when(billDao.findById("")).thenReturn(Optional.of(bill));
			Bill bil= billService.getBillById(0);
			assertEquals("", bil.getBillId());
			assertEquals("", bil.getBillDate());
		}
		@Test
		void testGetAllBill() {
			Bill bil1 = new Bill(0, null, 0, 0);
			Bill bil2 = new Bill(0, null, 0, 0);
			List<Bill> billList = new ArrayList<>();
			billList.add(bil1);
			billList.add(bil2);
			Mockito.when(billDao.findAll()).thenReturn(billList);
			List<Bill> bill = billService.getAllBill();
			assertEquals(2, bill.size());
			assertEquals("", bill.get(0).getBillId());
			assertEquals("", bill.get(0).getBillDate());
			assertEquals("", bill.get(1).getTotalItem());
			assertEquals("", bill.get(1).getTotalCost());
		}  
		@Test
		void testAddBill() {
			Bill bill = new Bill(0, null, 0, 0);
			Mockito.when(billDao.save(bill)).thenReturn(bill);
			Bill newBill = billService.addBill(bill);
			assertEquals("", newBill.getBillId());
			assertEquals("", newBill.getBillDate());
			assertEquals("", newBill.getTotalItem());
			assertEquals("", newBill.getTotalCost());
		}  
		
		@Test
		void testUpdateBill() {
			Bill bill = new Bill(0, null, 0, 0);
			Mockito.when(billDao.findById(1024)).thenReturn(Optional.of(bill));
			Mockito.when(billDao.save(bill)).thenReturn(bill);
			Bill updatedBill = billService.updateBill(1024, bill);
			assertEquals("", updatedBill.getBillId());
		} 
		
				@Test
		void testRemoveBill1() {
			Bill bill= new Bill(0, null, 0, 0);
			Mockito.when(billDao.findById(1024)).thenReturn(Optional.of(bill));
			billDao.removeById(1024);
			Bill bil = billService.removeBill(1024);
			assertEquals("Teja", bill.getBillId());
		}
		@Test
		void testRemoveBill() {
			Bill bill = new Bill(0, null, 0, 0);
			Mockito.when(billDao.save(bill)).thenReturn(bill);
			Bill newBill = billService.addBill(bill);
			assertEquals("", newBill.getBillId());
			assertEquals("", newBill.getBillDate());
			assertEquals("", newBill.getTotalItem());
			assertEquals("", newBill.getTotalCost());
		}  


		
		}
  */
