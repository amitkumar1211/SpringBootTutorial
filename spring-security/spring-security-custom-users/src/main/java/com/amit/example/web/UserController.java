package com.amit.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String greetingAll() {
		return "hello All";
	}
	
	@GetMapping("/user")
	public String greetingUser() {
		return "hello User";
	}

}
