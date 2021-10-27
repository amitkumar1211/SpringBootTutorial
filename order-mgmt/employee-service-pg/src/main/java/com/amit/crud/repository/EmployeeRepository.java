package com.amit.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amit.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByFirstName(String firstName);
	
	Employee findByFirstNameAndLastName(String firstName, String LastName);
	
	List<Employee> findTop10ByAge(Integer Age);
	
	@Query("select e from Employee e where e.emailId = ?1")
	Employee findByEmailId(String emailId);


}
