package com.techfeense.virtualstoreorder.data;

import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long> {
	OrderItemEntity findByOrderOrderIdAndProductId(String orderId, String productId);	
}
