package com.techfeense.virtualstoreorder.model;

import java.sql.Date;

import com.techfeense.virtualstoreorder.data.ORDER_STATUS;

public class CreateOrderResponseModel {
	private String orderId;
	private String idCustomer;
	private Date orderDate;
	private double total;
	private ORDER_STATUS status;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ORDER_STATUS getStatus() {
		return status;
	}
	public void setStatus(ORDER_STATUS status) {
		this.status = status;
	}
	
	
}
