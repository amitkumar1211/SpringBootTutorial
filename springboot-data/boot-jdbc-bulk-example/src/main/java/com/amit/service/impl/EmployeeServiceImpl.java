package com.amit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.dao.EmployeeDao;
import com.amit.model.Employee;
import com.amit.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	public void getAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}

}