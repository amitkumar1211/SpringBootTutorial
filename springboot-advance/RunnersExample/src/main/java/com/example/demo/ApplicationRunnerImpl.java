package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@Order(2)
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
	
	@Autowired
	private CountryRepository countryRepository;
	
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner, printing all arguments...");
        Arrays.stream(args.getSourceArgs()).forEach(System.out::println);
        System.out.println("NonOptionArgs: "+args.getNonOptionArgs());
        System.out.println("OptionNames: "+args.getOptionNames());
        
        for(String key: args.getOptionNames()) {
        	System.out.println("Option Name: "+key);
        	System.out.println("Option Value: "+args.getOptionValues(key));
        }
        
        countryRepository.save(new Country("India", 45000000));
        countryRepository.save(new Country("USA", 46000000));
        countryRepository.save(new Country("UK", 47000000));
        
        countryRepository.findAll().forEach((country) -> {
        	System.out.println("country: "+country);
        });
    }
}