package com.amit.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.demo.model.Order;
import com.amit.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllProduct(){
		return ResponseEntity.ok().body(orderService.findOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(orderService.findOrderByOrderId(id));
	}
	
	@PostMapping
	public ResponseEntity<Order> createProduct(@RequestBody Order order){
		return ResponseEntity.ok().body(this.orderService.createOrder(order));
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable long orderId, @RequestBody Order order){
		return ResponseEntity.ok().body(this.orderService.updateOrder(orderId, order));
	}

	/*
	 * @DeleteMapping("/{id}") public HttpStatus deleteOrder(@PathVariable long id){
	 * this.orderService.deleteOrder(id); return HttpStatus.OK; }
	 */

}
