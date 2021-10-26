package com.amit.dao;

import java.util.List;

import com.amit.model.Employee;

public interface EmployeeDao {
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
}