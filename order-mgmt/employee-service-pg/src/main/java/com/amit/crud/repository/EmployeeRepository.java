package com.amit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
