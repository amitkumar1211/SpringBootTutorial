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
    
    public Customer findCustomerById(int customerId) {
    	customerId = customerId - 1;
    	return customers.get(customerId);
    }
    
    public String addCustomer(Customer customer) {
    	customers.add(customer);
    	return "Successfully added a new Customer!";
    }
    
    public Customer updateCustomerByName(String name, int customerId) {
    	customerId = customerId - 1;
    	Customer existingCust = customers.get(customerId);
    	if(existingCust != null) {
    		existingCust.setName(name);
    		customers.add(customerId, existingCust);
    	}
    	return customers.get(customerId);
    }
    
    public Customer updateCustomer(Customer customer, int customerId) {
    	customerId = customerId - 1;
    	Customer existingCust = customers.get(customerId);
    	if(existingCust != null) {
    		customers.add(customerId, customer);
    	}
    	return customers.get(customerId);
    }
    
    public String deleteCustomer(int customerId) {
    	customerId = customerId - 1;
    	customers.remove(customerId);
    	return "Customer having id: "+ customerId+" removed successfully";
    }
    
    public Customer getCustomerByName(String name) {
    	Customer customerByName = new Customer();
    	for(Customer customer: customers) {
    		if(name.equalsIgnoreCase(customer.getName())) {
    			customerByName = customer;
    		}
    	}
    	return customerByName;
    }
}
