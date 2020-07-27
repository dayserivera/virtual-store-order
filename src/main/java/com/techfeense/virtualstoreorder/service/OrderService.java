package com.techfeense.virtualstoreorder.service;

import com.techfeense.virtualstoreorder.data.OrderEntity;

public interface OrderService {
	OrderEntity createOrder(OrderEntity order);
}
