package com.techfeense.virtualstoreorder.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordered_item")
public class OrderedItemEntity implements Serializable {

	private static final long serialVersionUID = -1744179762532424980L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private long productId;
	
	@Column(nullable=false)
	private double unitPrice;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false)
	private double totalPrice;
	
	@ManyToOne
	private OrderEntity order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
}
