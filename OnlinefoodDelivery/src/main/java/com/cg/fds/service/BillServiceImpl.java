 package com.cg.fds.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.dao.IBillDao;
import com.cg.fds.entity.Bill;
import com.cg.fds.exception.BillFoundException;
import com.cg.fds.exception.BillNotFoundException;


@Service
public class BillServiceImpl implements IBillService {
	//private static final String String = null;
	//private static final Bill Bill = null;
	//private static final com.cg.fds.entity.Bill bill = null;
	
	@Autowired
	IBillDao billDao;

	@Override
	public List<Bill> getAllBill() {
		return billDao.findAll();

	}

	@Override
	public Bill getBillById(int billId) throws BillNotFoundException {
			Optional<Bill> bill = billDao.findById(billId);
			if(!bill.isPresent()) {
				throw new BillNotFoundException("Bill is not present with given Id" +billId);
			}
			return bill.get();
		}

	
	@Override
	public Bill addBill(Bill bill) {
		
			Optional<Bill> Bil = billDao.findById(bill.getBillId());
			if (bill.isPresent()) {
				throw new BillFoundException("Bill already exists with given Id " + bill.getBillId());
			}
			return billDao.save(bill);
		}
	
	@Override
	public Bill updateBill(int billId, Bill bill) {
	Bill bil = billDao.findById(billId).get();
		bil.setTotalCost(bill.getTotalCost());
		return billDao.save(bill);
		}
		
	@Override
	public Bill removeBill(int billId) {
	Bill bil = billDao.findById(billId).get();
		billDao.deleteById(billId);                                 
		return bil;
	}
	
	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) {
		return ((BillServiceImpl) billDao).viewBills(startDate, endDate);
		}

	@Override
	public List<Bill> viewBills(String custId) {
			return ((BillServiceImpl) billDao).viewBills(custId);
	}
} 
	

