package com.amit.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByFirstName(String firstName);
	
	Employee findByFirstNameAndLastName(String firstName, String LastName);
	
	List<Employee> findTop10ByAge(Integer Age);


}
