package com.amit.demo.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Order {
	
	
	public Order() {
		this.products = null;
		
	}
	
	public Order(Long id, String orderDesc, int quantity, BigDecimal total, List<Product> products) {
		super();
		this.id = id;
		this.orderDesc = orderDesc;
		this.quantity = quantity;
		this.total = total;
		this.products = products;
	}

	@Id
	private Long id;
	
	private String orderDesc;
	
	private int quantity;
	
	private BigDecimal total;
	
	private final List<Product> products;

}
