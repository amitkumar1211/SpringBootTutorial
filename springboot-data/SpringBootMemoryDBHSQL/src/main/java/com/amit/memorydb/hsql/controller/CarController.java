package com.amit.memorydb.hsql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.memorydb.hsql.model.Car;
import com.amit.memorydb.hsql.repository.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	CarRepository carRepository;
	
	@GetMapping({"/cars"})
    public List<Car> books(Model model) {
		
        return (List<Car>) carRepository.findAll();
    }

}
