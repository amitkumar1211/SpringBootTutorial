package com.amit.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {


    @GetMapping
    public ResponseEntity<String> getCustomers() {
        return new ResponseEntity<>("Hello Customer", HttpStatus.OK);
    }
    
   
}
