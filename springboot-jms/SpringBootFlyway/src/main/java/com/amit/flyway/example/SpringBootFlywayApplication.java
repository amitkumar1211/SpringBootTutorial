package com.amit.flyway.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amit.flyway.example.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootFlywayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlywayApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner runner(BookRepository repository) {
        return r -> log.info(repository.findAll().toString());
    }

}
