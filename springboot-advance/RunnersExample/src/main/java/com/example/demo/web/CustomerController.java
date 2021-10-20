package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CountryRepository countryRepository;

    @GetMapping
    public ResponseEntity<String> getCustomers() {
        return new ResponseEntity<>("Hello Customer", HttpStatus.OK);
    }
    
    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<List<City>>((List<City>) cityRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getCountries() {
        return new ResponseEntity<List<Country>>((List<Country>) countryRepository.findAll(), HttpStatus.OK);
    }
    
   
}
