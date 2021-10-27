package com.amit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.demo.model.Order;
import com.amit.demo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order findOrderByOrderId(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public List<Order> findOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order updateOrder(Long id, Order order) {
		order.setId(id);
		return orderRepository.save(order);
	}

}
