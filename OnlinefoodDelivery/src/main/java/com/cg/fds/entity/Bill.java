package com.cg.fds.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;


@Entity
@Table(name = "bill")
public class Bill {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "billId")
	private int billId;
	
	@Column(name = "billDate" )
	private LocalDateTime billDate;
		
	@Column(name = "totalItem", unique = true, length = 50, nullable = false)
	//@Max(10)
	private int totalItem;
	
	@Column(name = "totalCost")
	//@Max(10)
	private double totalCost;
	
	//private OrderDetails order;
	 public Bill() {}
	public Bill(int billId, LocalDateTime billDate, int totalItem, double totalCost) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		//this.order = order;
	}

	
	

	public Bill(double d, int i, int j) {
		// TODO Auto-generated constructor stub
	}




	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/*public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	} */


	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", totalItem=" + totalItem + ", totalCost="
				+ totalCost + "]";
	}


	
	
public boolean isPresent() {
		
		return true;
	}
 

	
	public Bill get() {
				return null;
	}

} 