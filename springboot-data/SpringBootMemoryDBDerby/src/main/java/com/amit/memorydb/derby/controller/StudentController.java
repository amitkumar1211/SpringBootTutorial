package com.amit.memorydb.derby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.memorydb.derby.model.Student;
import com.amit.memorydb.derby.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping
    public List<Student> allStudents() {
        return (List<Student>) studentRepository.findAll();
    }
	
	@GetMapping({"/{id}"})
    public Student studentById(@PathVariable int id) {
        return studentRepository.findById(id).get();
    }

}
