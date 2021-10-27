package com.amit.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.crud.exception.ResourceNotFoundException;
import com.amit.crud.model.Employee;
import com.amit.crud.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

//	@GetMapping
//	public List<Employee> getAllEmployees() {
//		return employeeRepository.findAll();
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
		if(Strings.isBlank(firstName) && Strings.isBlank(lastName)) {
			return ResponseEntity.ok().body(employeeRepository.findAll());
		} else if(Strings.isBlank(lastName)){
			List<Employee> employeesByFirstName = employeeRepository.findByFirstName(firstName);
			return ResponseEntity.ok().body(employeesByFirstName);
		} else {
			List<Employee> employeesByName = new ArrayList<Employee>();
			employeesByName.add(employeeRepository.findByFirstNameAndLastName(firstName, lastName));
			return ResponseEntity.ok().body(employeesByName);
		}
	}
	
	@GetMapping("/ages/{age}")
	public ResponseEntity<List<Employee>> getEmployeeByAge(@PathVariable Integer age){
		List<Employee> employeesTop10ByAge = employeeRepository.findTop10ByAge(age);
		return ResponseEntity.ok().body(employeesTop10ByAge);
	}
	
	@GetMapping("/emailId/{emailId}")
	public ResponseEntity<Employee> getTop10EmployeesByEmailId(@PathVariable String emailId){
		Employee employee = employeeRepository.findByEmailId(emailId);
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
