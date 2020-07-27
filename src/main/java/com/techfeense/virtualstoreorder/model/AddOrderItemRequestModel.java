package com.techfeense.virtualstoreorder.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddOrderItemRequestModel {
	@NotNull(message="orderId cannot be null")
	private String orderId;

	@NotNull(message="productId cannot be null")
	private String productId;
	
	private double unitPrice;
	
	@Min(value=1)
	private int quantity;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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
	
}
