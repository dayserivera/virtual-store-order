package com.techfeense.virtualstoreorder.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techfeense.virtualstoreorder.data.OrderEntity;
import com.techfeense.virtualstoreorder.data.OrderItemEntity;
import com.techfeense.virtualstoreorder.model.AddOrderItemRequestModel;
import com.techfeense.virtualstoreorder.model.AddOrderItemResponseModel;
import com.techfeense.virtualstoreorder.model.CreateOrderRequestModel;
import com.techfeense.virtualstoreorder.model.CreateOrderResponseModel;
import com.techfeense.virtualstoreorder.model.DetailOrderItemResponseModel;
import com.techfeense.virtualstoreorder.model.DetailOrderResponseModel;
import com.techfeense.virtualstoreorder.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<CreateOrderResponseModel> createOrder(@Valid @RequestBody CreateOrderRequestModel orderDetail){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		OrderEntity order = modelMapper.map(orderDetail, OrderEntity.class);
		
		orderService.createOrder(order);
		
		CreateOrderResponseModel returnValue = modelMapper.map(order, CreateOrderResponseModel.class);
		
		return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
	}
	
	@GetMapping
	public DetailOrderResponseModel getOrderDetails(@Valid @PathVariable String orderId) {
		OrderEntity order = orderService.getOrder(orderId);
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		DetailOrderResponseModel returnValue = modelMapper.map(order, DetailOrderResponseModel.class);
		
		List<DetailOrderItemResponseModel> detailOrderItemResponseModelList = order.getOrderedItens()
				  .stream()
				  .map(product -> modelMapper.map(product, DetailOrderItemResponseModel.class))
				  .collect(Collectors.toList());
		
		returnValue.setOrderItens(detailOrderItemResponseModelList);
		
		return returnValue;
		
	}
	
	@RequestMapping("/items")
	@PostMapping
	public ResponseEntity<AddOrderItemResponseModel> addOrderItem(@Valid @RequestBody AddOrderItemRequestModel orderItemDetail){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		OrderItemEntity orderItem = modelMapper.map(orderItemDetail, OrderItemEntity.class);
		orderItem.setOrder(new OrderEntity());
		orderItem.getOrder().setOrderId(orderItemDetail.getOrderId());
		
		orderService.addOrderItem(orderItem);
		
		AddOrderItemResponseModel returnValue = modelMapper.map(orderItem, AddOrderItemResponseModel.class);
		returnValue.setOrderId(orderItem.getOrder().getOrderId());
		
		return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
	}
}
