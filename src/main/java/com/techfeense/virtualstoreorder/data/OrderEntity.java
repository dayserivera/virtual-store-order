package com.techfeense.virtualstoreorder.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity implements Serializable{

	private static final long serialVersionUID = -9098742740217317863L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String orderId;
	
	@Column(nullable=false)
	private String idCustomer;
	
	@Column(nullable=false)
	private Date orderDate;
	
	@Column(nullable=false)
	private double total;
	
	@Column(name="status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ORDER_STATUS status;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderedItemEntity> orderedItens;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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

	public List<OrderedItemEntity> getOrderedItens() {
		return orderedItens;
	}

	public void setOrderedItens(List<OrderedItemEntity> orderedItens) {
		this.orderedItens = orderedItens;
	}
	
}
