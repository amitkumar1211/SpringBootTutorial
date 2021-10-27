package com.amit.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.amit.demo.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

}
