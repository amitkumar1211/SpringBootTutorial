package com.amit.springboot.logging.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootDefaultLoggingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDefaultLoggingExampleApplication.class, args);
		log.info("Hello from lombok with slf4j");
	}

}
