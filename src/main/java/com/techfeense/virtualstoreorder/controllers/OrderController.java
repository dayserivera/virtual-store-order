package com.techfeense.virtualstoreorder.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techfeense.virtualstoreorder.data.OrderEntity;
import com.techfeense.virtualstoreorder.model.CreateOrderRequestModel;
import com.techfeense.virtualstoreorder.model.CreateOrderResponseModel;
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
}
