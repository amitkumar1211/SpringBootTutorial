package com.amit.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.demo.model.Customer;
import com.amit.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Customer> getCustomer(){
		return customerService.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id){
		return customerService.findById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		Customer existingCustomer = customerService.findById(id);
		if(existingCustomer != null) {
			return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Long id){
		return new ResponseEntity<String>(customerService.deleteCustomer(id), HttpStatus.ACCEPTED);
	}

}
