package com.cg.fds.service;

//import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;

import com.cg.fds.entity.Bill;
//import com.cg.fds.exception.BillNotFoundException1;

public interface IBillService {

	
     List<Bill> getAllBill();
   Bill getBillById(int billId);
   Bill addBill(Bill bill);
   Bill updateBill(int billId, Bill bill);
   Bill removeBill(int billId);
   public  List<Bill> viewBills(LocalDateTime billDate);
   List<Bill> viewBills(String custId);
   List<Bill> viewBills();
  
  
}
 