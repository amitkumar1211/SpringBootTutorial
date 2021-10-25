package com.amit.demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.util.Strings;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.demo.model.Customer;
import com.amit.demo.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public ResponseEntity<List<Customer>> getCustomer(@RequestParam(required = false) String lastName) {
		try {
			if (Strings.isBlank(lastName)) {
				return new ResponseEntity<List<Customer>>(customerService.findAll(), HttpStatus.OK);
			} else {

				return new ResponseEntity<List<Customer>>(customerService.findByLastName(lastName), HttpStatus.OK);
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<Customer>>(new ArrayList<Customer>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.findById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		Customer existingCustomer = customerService.findById(id);
		if (existingCustomer != null) {
			return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
		return new ResponseEntity<String>(customerService.deleteCustomer(id), HttpStatus.ACCEPTED);
	}

}
