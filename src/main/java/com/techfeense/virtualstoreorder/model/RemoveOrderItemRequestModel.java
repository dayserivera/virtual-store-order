package com.techfeense.virtualstoreorder.model;

import javax.validation.constraints.NotNull;

public class RemoveOrderItemRequestModel {
	@NotNull(message="orderId cannot be null")
	private String orderId;

	@NotNull(message="productId cannot be null")
	private String productId;
	
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
	
}
