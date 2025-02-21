package com.ajay.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ajay.dto.OrderRequestDto;
import com.ajay.enity.Orders;
import com.ajay.repository.OrdersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {

	private final OrdersRepository orderRepository;
	private final ModelMapper modelMapper;

	public List<OrderRequestDto> getAllOrders() {

		log.info("Fetching all orders");

		List<Orders> orders = orderRepository.findAll();

		return orders.stream().map(order -> modelMapper.map(order, OrderRequestDto.class)).toList();
	}

	public OrderRequestDto getOrdertyld(Long id) {
		
		log.info("Fetehing orden with ID: {}", id);
		
		Orders order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
		
		return modelMapper.map(order, OrderRequestDto.class);

	}
}
