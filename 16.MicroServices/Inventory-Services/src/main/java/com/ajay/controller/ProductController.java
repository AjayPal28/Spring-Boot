package com.ajay.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.dto.ProductDto;
import com.ajay.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllnventory() {
		List<ProductDto> inventories = productService.getAlLInventory();
		return ResponseEntity.ok(inventories);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getInventorylyId(@PathVariable Long id) {
		ProductDto inventory = productService.getProducteyld(id);
		return ResponseEntity.ok(inventory);
	}

}
