 package com.cg.fds.service;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.dao.IBillDao;
import com.cg.fds.dao.IOrderDetailsDao;
import com.cg.fds.entity.Bill;
import com.cg.fds.exception.BillFoundException;
import com.cg.fds.exception.BillNotFoundException;


@Service
public class BillServiceImpl implements IBillService {
	
	@Autowired
	IBillDao billDao;
		
	@Autowired
	IOrderDetailsDao orderDao;

	private Bill bill;

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
	public List<Bill> viewBills(LocalDateTime billDate) {
		
		return billDao.findAll();
	}

	public Bill updateBill(int i, LocalDateTime localDateTime, int j, int k) {

		return null;
	}

	@Override
	public List<Bill> viewBills(String custId) {
	
		return null;
	}

	@Override
	public List<Bill> viewBills() {
		
		return null;
	}
		
	/*@Override
	public List<Bill> viewBills(int orderId) {	
	OrderDetails order=orderDao.findById(orderId).get();
	Bill bill=billDao.getById(billId); 
	 return bill;
	}
	*/
	

}
