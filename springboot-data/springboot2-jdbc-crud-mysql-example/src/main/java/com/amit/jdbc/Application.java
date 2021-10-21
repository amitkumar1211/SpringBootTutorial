package com.amit.jdbc;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amit.jdbc.model.Employee;
import com.amit.jdbc.repository.EmployeeJDBCRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeJDBCRepository employeeRepository;
	
	@Override
	public void run(String... args) {

		logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10011, "Gokul", "Pandit", "gokul@gmail.com")));
		logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10012, "Ganesh", "Purohit", "ganesh@gmail.com")));
		logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10013, "Tarak", "Mehta", "tarak@gmail.com")));
		
		logger.info("Employee id 10011 -> {}", employeeRepository.findById(10011L));

		logger.info("Update 10003 -> {}", employeeRepository.update(new Employee(10011, "Ramesh", "Singh", "ramesh@gmail.com")));

		//employeeRepository.deleteById(10013);

		logger.info("All users -> {}", employeeRepository.findAll());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
