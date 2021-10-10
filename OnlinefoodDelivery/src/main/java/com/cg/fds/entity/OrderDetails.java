package com.cg.fds.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetails {

	@Id
	private int orderId;
	private LocalDateTime orderDate;
	private String orderStatus;
	//private int TotalAmount;

	// @JsonIgnore
	// @OneToOne(mappedBy ="order_fk", cascade= {CascadeType.PERSIST,
	// CascadeType.REFRESH})

	// constructors
	public OrderDetails() {
	}

	public OrderDetails(int orderId, LocalDateTime orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		//this.TotalAmount = totalAmount;
	}

	// getter & setter
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

/*	public int getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.TotalAmount = totalAmount;
	} */

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+  "]";
	}

/*	public double getOrderDetails() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
}