package com.amit.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationEventExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEventExampleApplication.class, args);
	}
	
	/*
	 * @Bean(initMethod="runAfterObjectCreated") public BeanInitMethodImpl
	 * getFunnyBean() { System.out.println("Bean Init called."); return new
	 * BeanInitMethodImpl(); }
	 */


}
