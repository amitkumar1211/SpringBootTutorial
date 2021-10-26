package com.amit.demo.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amit.demo.model.Customer;
import com.amit.demo.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
public class CustomerServiceImpl implements CustomerService {
	
//	private static final org.slf4j.Logger log = 
//		    org.slf4j.LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	final String DeleteMessage = "Customer successfully deleted !!";

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		log.debug("Request for customer update", customer);
		return customerRepository.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		log.debug("Request to find the customer having id: {}", id);
		return customerRepository.findById(id).get();
	}

	@Override
	public List<Customer> findAll() throws InterruptedException, ExecutionException {
//		return (List<Customer>) customerRepository.findAll();
		return (List<Customer>) customerRepository.findAllCustomers().get();
	}

	@Override
	public String deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		log.debug(DeleteMessage);
		return DeleteMessage;
		
	}
	
	@Override
	public List<Customer> findByLastName(String lastName) throws InterruptedException, ExecutionException{
		return customerRepository.findByLastName(lastName).get();
	}

}
