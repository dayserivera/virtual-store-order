package com.techfeense.virtualstoreorder.data;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

	OrderEntity findByOrderId(String orderId);
	
}
