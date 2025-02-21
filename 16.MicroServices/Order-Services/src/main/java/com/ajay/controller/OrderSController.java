package com.ajay.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.dto.OrderRequestDto;
import com.ajay.service.OrdersService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
public class OrderSController {

	private final OrdersService ordersService;

	@GetMapping("/helloOrders")
	public String helloOrders() {
		return "Hello from Orders Service";
	}

	@GetMapping
	public ResponseEntity<List<OrderRequestDto>> getAllorders(HttpServletRequest httpServletRequest) {
		log.info("Fetching all orders via controller");
		List<OrderRequestDto> orders = ordersService.getAllOrders();
		return ResponseEntity.ok(orders);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderRequestDto> getOrdersyld(@PathVariable(name = "id") Long id) {
		log.info("Fetching Order with ID :{} via Controller", id);
		OrderRequestDto order = ordersService.getOrdertyld(id);
		return ResponseEntity.ok(order);

	}

}
