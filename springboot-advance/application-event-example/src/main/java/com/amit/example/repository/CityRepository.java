package com.amit.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.example.model.City;


@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
