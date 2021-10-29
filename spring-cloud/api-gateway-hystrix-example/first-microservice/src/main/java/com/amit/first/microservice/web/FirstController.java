package com.amit.first.microservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class FirstController {
	
	@Value("${service.instance.name}")
	private String instanceName;

	@GetMapping("/message")
	public String test() {
		return "Hello Called in First Service "+instanceName;
	}
}