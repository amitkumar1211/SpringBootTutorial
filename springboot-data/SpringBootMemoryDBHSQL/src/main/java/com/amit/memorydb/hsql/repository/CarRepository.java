package com.amit.memorydb.hsql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.memorydb.hsql.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}
