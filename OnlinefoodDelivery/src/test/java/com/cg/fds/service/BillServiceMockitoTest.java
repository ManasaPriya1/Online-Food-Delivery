package com.cg.fds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
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
	void testGetBillByBillId() throws BillNotFoundException {

		Bill bill = new Bill(3, LocalDateTime.of(2021, 10, 6, 11, 43, 39, 284), 200, 2);
		Mockito.when(billDao.findById(3)).thenReturn(Optional.of(bill));
		Bill bil = billService.getBillById(3);
		assertEquals(3, bil.getBillId());
		assertEquals(LocalDateTime.of(2021, 10, 6, 11, 43, 39, 284), bill.getBillDate());
		assertEquals(200, bill.getTotalCost());
		assertEquals(2, bill.getTotalItem());
	}

	@Test
	void testGetAllBill() {
		Bill bil1 = new Bill(3, LocalDateTime.of(2021, 10, 6, 11, 43, 39, 284), 200, 2);
		Bill bil2 = new Bill(4, LocalDateTime.of(2021, 10, 3, 823, 32, 482), 1000, 5);
		List<Bill> billList = new ArrayList<>();
		billList.add(bil1);
		billList.add(bil2);
		Mockito.when(billDao.findAll()).thenReturn(billList);
		List<Bill> bill = billService.getAllBill();
		assertEquals(9, bill.size());
		assertEquals(3, bill.get(0).getBillId());
		assertEquals(LocalDateTime.of(2021, 10, 6, 11, 43, 39, 284), bill.get(0).getBillDate());
		assertEquals(4, bill.get(1).getBillId());
		assertEquals(LocalDateTime.of(2021, 10, 3, 8, 23, 32, 482), bill.get(1).getBillDate());

	}

	@Test
	void testAddBill() {
		Bill bill = new Bill(1, LocalDateTime.of(2021, 10, 10, 10, 28, 29, 455), 300, 5);
		Mockito.when(billDao.save(bill)).thenReturn(bill);
		Bill newBill = billService.addBill(bill);
		assertEquals(1, newBill.getBillId());
		assertEquals(LocalDateTime.of(2021, 10, 10, 10, 28, 29, 455), bill.getBillDate());
		assertEquals(300, newBill.getTotalCost());
		assertEquals(5, newBill.getTotalItem());

	}

	@Test
	void testUpdateBill() {
		Bill bill = new Bill(1, LocalDateTime.of(2021, 10, 10, 10, 28, 29, 455), 300, 5);
		Mockito.when(billDao.findById(1)).thenReturn(Optional.of(bill));
		Mockito.when(billDao.save(bill)).thenReturn(bill);
		Bill updatedBill = billService.updateBill(5, LocalDateTime.of(2021, 10, 10, 10, 28, 29, 455), 300, 5);
		assertEquals(LocalDateTime.of(2021, 10, 10, 10, 28, 29, 455), bill.getBillDate());
	}

	@Test
	void testRemoveBillById() {
		Bill bill = billService.removeBill(0);

	}

}
