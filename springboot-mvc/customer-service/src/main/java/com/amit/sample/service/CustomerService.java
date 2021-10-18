package com.amit.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.sample.model.Customer;

@Service
public class CustomerService {

	List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Amit");
        customer.setEmail("amit@gmail.com");
        customer.setAge(32);
        customers.add(customer);
        return customers;
    }
    
    public String addCustomer(Customer customer) {
    	customers.add(customer);
    	return "Successfully added a new Customer!";
    }
    
    public Customer updateCustomer(Customer customer, int customerId) {
    	customerId = customerId - 1;
    	Customer existingCust = customers.get(customerId);
    	if(existingCust != null) {
    		customers.add(customerId, customer);
    	}
    	return customers.get(customerId);
    }
}
