package com.amit.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.example.model.City;
import com.amit.example.repository.CityRepository;



@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CityRepository cityRepository;
	

    @GetMapping
    public ResponseEntity<String> getCustomers() {
        return new ResponseEntity<>("Hello Customer", HttpStatus.OK);
    }
    
    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<List<City>>((List<City>) cityRepository.findAll(), HttpStatus.OK);
    }
    
    
   
}
