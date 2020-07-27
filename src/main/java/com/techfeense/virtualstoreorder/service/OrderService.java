package com.techfeense.virtualstoreorder.service;

import com.techfeense.virtualstoreorder.data.OrderEntity;
import com.techfeense.virtualstoreorder.data.OrderItemEntity;

public interface OrderService {
	OrderEntity createOrder(OrderEntity order);

	OrderItemEntity addOrderItem(OrderItemEntity orderItem);
	
	OrderEntity getOrder(String orderId);
}
