package com.cg.fds.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.OneToOne;
//import javax.validation.constraints.Max;

@Entity
@Table(name = "bill")
public class Bill  {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "billId")
	private int billId;
	
	@Column(name = "billDate" )
	private LocalDateTime billDate;
		
	@Column(name = "totalItem", unique = true, length = 50, nullable = false)
	//@Max(10)
	private int totalItem;
	
	@Column(name = "totalCost")
	//@Max(10)
	private double totalCost;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="order_fk")
	OrderDetails order;
	
/*private List<OrderDetails> orderDetails = new ArrayList<>();
	
	public Double gettotalCost1() {
		double sum = 0D;
		List<OrderDetails> orderDetails = getOrderDetails();
			for(OrderDetails od :orderDetails) {
				sum += od.getOrderDetails();
			}
			return sum;
	} */
		
	private List<OrderDetails> getOrderDetails() {
				return null;
	}

	public Bill(int i, LocalDateTime localDateTime, int j, int k) {}
	public Bill() {}
	public Bill(int billId, LocalDateTime billDate, int totalItem, double totalCost, OrderDetails order) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		this.order = order;
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

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	} 

	//toString
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", totalItem=" + totalItem + ", totalCost="
				+ totalCost + ", order=" + order + "]";
	}

/*   @Transient
   public Double gettotalCost() {
	   return getOrderDetails().getPrice()*getQuantity();
	   
   } */
 
 //  private int  getPrice() { 
	  // return 0;
//	}
   
/*   private int getQuantity() {
	   return 0;
} */

		public boolean isPresent() {
			
			return true;
		} 

} 