package com.cg.fds.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.cg.fds.entity.Bill;

public interface IBillService {

	
   List<Bill> getAllBill();
   Bill getBillById(int billId);
   Bill addBill(Bill bill);
   Bill updateBill(int billId, Bill bill);
   Bill removeBill(int billId);
   List<Bill> viewBills(LocalDate startDate, LocalDate endDate);
   List<Bill> viewBills(String custId);
}
 