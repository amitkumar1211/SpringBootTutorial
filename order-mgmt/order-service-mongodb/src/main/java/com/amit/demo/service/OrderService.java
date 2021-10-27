package com.amit.demo.service;

import java.util.List;

import com.amit.demo.model.Order;

public interface OrderService {
	
	public Order createOrder(Order order);
	
	public Order findOrderByOrderId(Long OrderId);
	
	public List<Order> findOrders();
	
	public Order updateOrder(Long OrderId, Order order);

}
