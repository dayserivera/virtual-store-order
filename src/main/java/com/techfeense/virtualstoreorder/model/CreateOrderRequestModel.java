package com.techfeense.virtualstoreorder.model;

import javax.validation.constraints.NotNull;

public class CreateOrderRequestModel {
	@NotNull(message="idCustomer cannot be null")
	private String idCustomer;

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	
}
