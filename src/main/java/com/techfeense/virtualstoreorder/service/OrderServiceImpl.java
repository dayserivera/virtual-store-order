package com.techfeense.virtualstoreorder.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfeense.virtualstoreorder.data.ORDER_STATUS;
import com.techfeense.virtualstoreorder.data.OrderEntity;
import com.techfeense.virtualstoreorder.data.OrderItemEntity;
import com.techfeense.virtualstoreorder.data.OrderItemRepository;
import com.techfeense.virtualstoreorder.data.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public OrderEntity createOrder(OrderEntity order) {
		order.setOrderId(UUID.randomUUID().toString());
		order.setOrderDate(new Date());
		order.setStatus(ORDER_STATUS.OPEN);
		order.setTotal(0);
		orderRepository.save(order);
		
		return order;
	}

	@Override
	public OrderItemEntity addOrderItem(OrderItemEntity orderItem) {
		OrderEntity order = orderRepository.findByOrderId(orderItem.getOrder().getOrderId());
		orderItem.setOrder(order);
		orderItem.setTotalPrice(orderItem.getUnitPrice() * orderItem.getQuantity());
		
		orderItemRepository.save(orderItem);
		
		return orderItem;
	}

	@Override
	public OrderEntity getOrder(String orderId) {
		OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
		
		return orderEntity;
	}

}
