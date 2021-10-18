package com.amit.sample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sample.model.Customer;
import com.amit.sample.service.CustomerService;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }
    
    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
    	return customerService.addCustomer(customer);
    }

   
}
