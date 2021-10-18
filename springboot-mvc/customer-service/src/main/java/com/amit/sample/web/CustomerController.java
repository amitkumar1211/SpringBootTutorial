package com.amit.sample.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sample.exception.CustomerNotFoundException;
import com.amit.sample.model.Customer;
import com.amit.sample.service.CustomerService;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
	
	Map<Long, Customer> customerMap = new HashMap<>();

    @ModelAttribute("employees")
    public void initEmployees() {
        customerMap.put(1L, new Customer(1L, "John", 32, "john@gmail.com"));
        customerMap.put(2L, new Customer(2L, "Amit", 32, "amit@gmail.com"));
    }

	@Autowired CustomerService customerService;

    @GetMapping
    public ResponseEntity<Map<Long, Customer>> getCustomers(@RequestParam(required = false) String name) {
		/*
		 * if(name!=null) { List<Customer> customerList = new ArrayList<>();
		 * customerList.add(customerService.getCustomerByName(name)); return new
		 * ResponseEntity<>(customerList, HttpStatus.OK); } else { return new
		 * ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK); }
		 */
    	
    	return new ResponseEntity<>(customerMap, HttpStatus.OK); 
    }
    
    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long customerId) {
//    	return customerService.findCustomerById(customerId.intValue());
    	if(!customerMap.containsKey(customerId)) {
    		throw new CustomerNotFoundException();
    	} else {
    		return new ResponseEntity<>(customerMap.get(customerId), HttpStatus.OK);
    	}
    }
    
    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
    	return customerService.addCustomer(customer);
    }
    
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
    	return customerService.updateCustomer(customer, customerId.intValue());
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id.intValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PatchMapping("/{customerId}")
    public Customer updateName(@PathVariable Long customerId, @RequestBody String name) {
    	return customerService.updateCustomerByName(name, customerId.intValue());
    }
}
