package com.cg.fds.dto;

import java.time.LocalDateTime;

//import lombok.Data;

//@Data
public class BillDto {
	private int BillId1;
	private  LocalDateTime billDate1;
	
	private  int totalItem1;
	private double totalCost1;
	

	
	public int getBillId() {
		return BillId1;
	}
	public void setBillId(int billId) {
		BillId1 = billId;
	}
	public LocalDateTime getBillDate() {
		return billDate1;
	}
	public void setBillDate(LocalDateTime billDate) {
		this.billDate1 = billDate;
	}
	public int getTotalItem() {
		return totalItem1;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem1 = totalItem;
	}
	public double getTotalCost() {
		return totalCost1;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost1 = totalCost;
	}
	private int BillId;
	private  LocalDateTime billDate;
	
	private  int totalItem;
	private double totalCost;
	


	
	}
