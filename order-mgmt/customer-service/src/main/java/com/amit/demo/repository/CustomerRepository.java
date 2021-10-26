package com.amit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.demo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
