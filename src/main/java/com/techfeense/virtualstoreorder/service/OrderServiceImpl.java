package com.techfeense.virtualstoreorder.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfeense.virtualstoreorder.data.ORDER_STATUS;
import com.techfeense.virtualstoreorder.data.OrderEntity;
import com.techfeense.virtualstoreorder.data.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public OrderEntity createOrder(OrderEntity order) {
		order.setOrderId(UUID.randomUUID().toString());
		order.setOrderDate(new Date());
		order.setStatus(ORDER_STATUS.OPEN);
		order.setTotal(0);
		orderRepository.save(order);
		
		return order;
	}

}
