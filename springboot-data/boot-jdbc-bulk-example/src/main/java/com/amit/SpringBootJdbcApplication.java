package com.amit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.amit.model.Employee;
import com.amit.service.EmployeeService;

@SpringBootApplication
public class SpringBootJdbcApplication {
	
	
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(10018, "Suresh", "Pandit", "suresh@gmail.com"));
		employees.add(new Employee(10019, "Rohan", "Purohit", "rohan@gmail.com"));
		employeeService.insertEmployees(employees);

		employeeService.getAllEmployees();
		

	}
}