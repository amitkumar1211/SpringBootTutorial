package com.amit.sample.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sample.model.Employee;


@RestController
public class EmployeeController {

    Map<Long, Employee> employeeMap = new HashMap<>();

    @ModelAttribute("employees")
    public void initEmployees() {
        employeeMap.put(1L, new Employee(1L, "John", "223334411", "rh"));
        employeeMap.put(2L, new Employee(2L, "Peter", "22001543", "informatics"));
        employeeMap.put(3L, new Employee(3L, "Mike", "223334411", "admin"));
    }

   
    @GetMapping(value = "/employees/{Id}", produces = {"application/json", "application/xml" } )
    public Employee getEmployeeById(@PathVariable final Long Id) {
        return employeeMap.get(Id);
    }
    
    @GetMapping(value = "/employees", produces = {"application/json", "application/xml" } )
    public Map<Long, Employee> getEmployees() {
        return employeeMap;
    }

    
 
    
}
