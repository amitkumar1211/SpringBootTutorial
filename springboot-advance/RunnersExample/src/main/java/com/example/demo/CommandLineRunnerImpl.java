package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;

@Order(1)
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
	
//	private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerImpl.class);
	
	@Autowired
	private CityRepository repository;
	
    @Override
    public void run(String... args) throws Exception {
//        System.out.println("CommandLineRunner, printing all arguments...");
//        Arrays.stream(args).forEach(System.out::println);
        repository.save(new City("Amritsar", 45000000));
        repository.save(new City("Mohali", 46000000));
        repository.save(new City("Ranchi", 47000000));
        
        repository.findAll().forEach((city) -> {
        	System.out.println("city "+city);
        });
        
    }
}
