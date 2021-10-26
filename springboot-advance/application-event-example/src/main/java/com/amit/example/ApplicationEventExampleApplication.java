package com.amit.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationEventExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEventExampleApplication.class, args);
	}
	
	@Bean(initMethod="init")
    public BeanInitMethodImpl beanInitMethodImpl() {
		System.out.println("Bean Init called.");
        return new BeanInitMethodImpl();
    }
}
