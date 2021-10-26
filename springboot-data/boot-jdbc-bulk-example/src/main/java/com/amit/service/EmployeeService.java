package com.amit.service;

import java.util.List;

import com.amit.model.Employee;

public interface EmployeeService {
	void insertEmployees(List<Employee> employees);
	void getAllEmployees();
}