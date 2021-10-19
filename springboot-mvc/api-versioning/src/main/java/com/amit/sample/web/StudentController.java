package com.amit.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sample.model.CollegeStudent;
import com.amit.sample.model.Name;
import com.amit.sample.model.SchoolStudent;

@RestController
@RequestMapping("/students")
public class StudentController {

	@GetMapping("v1/student")
	public SchoolStudent SchoolStudent() {
		return new SchoolStudent("Amit Kumar");
	}

	@GetMapping("v2/student")
	public CollegeStudent CollegeStudent() {
		return new CollegeStudent(new Name("Amit", "Kumar"));
	}

	@GetMapping(value = "/params", params = "version=1")
	public SchoolStudent paramV1() {
		return new SchoolStudent("Amit Kumar");
	}

	@GetMapping(value = "/params", params = "version=2")
	public CollegeStudent paramV2() {
		return new CollegeStudent(new Name("Amit", "Kumar"));
	}

	@GetMapping(value = "/headers", headers = "X-API-VERSION=1")
	public SchoolStudent headerV1() {
		return new com.amit.sample.model.SchoolStudent("Amit Kumar");
	}

	@GetMapping(value = "/headers", headers = "X-API-VERSION=2")
	public CollegeStudent headerV2() {
		return new CollegeStudent(new Name("Amit", "Kumar"));
	}

	//use Accept HTTP header
	@GetMapping(value = "/produces", produces = "application/vnd.company.app-v1+json")
	public SchoolStudent producesV1() {
		return new SchoolStudent("Amit Kumar");
	}

	//use Accept HTTP header
	@GetMapping(value = "/produces", produces = "application/vnd.company.app-v2+json")
	public CollegeStudent producesV2() {
		return new CollegeStudent(new Name("Amit", "Kumar"));
	}
}
