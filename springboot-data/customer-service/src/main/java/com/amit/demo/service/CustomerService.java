package com.amit.demo.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.amit.demo.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer findById(Long id);
	public List<Customer> findAll() throws InterruptedException, ExecutionException;
	public String deleteCustomer(Long id);
	public List<Customer> findByLastName(String lastName) throws InterruptedException, ExecutionException;

}
