package com.amit.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.amit.example.model.City;
import com.amit.example.repository.CityRepository;


@Component
public class ApplicationEventImpl {
	
	@Autowired
	private CityRepository repository;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
	    System.out.println("This is Application Ready Event");
	    repository.save(new City("Amritsar", 45000000));
        repository.save(new City("Mohali", 46000000));
        repository.save(new City("Ranchi", 47000000));
        
        repository.findAll().forEach((city) -> {
        	System.out.println("city "+city);
        });
	}

}
