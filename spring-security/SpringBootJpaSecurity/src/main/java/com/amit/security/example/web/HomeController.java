package com.amit.security.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.security.example.repository.UserRepository;
import com.amit.security.example.model.User;

@RestController
public class HomeController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		return "Welcome";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welcome User";
	}
	
	@GetMapping("/user/hello")
	public String greet() {
		return "Welcome and Hello User!";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin";
	}
	
	@PostMapping("/admin/users")
	public String createUser(@RequestBody User user) {
		userRepository.save(user);
		return "Successfully created";
	}
	
	@GetMapping("/admin/users")
	public String getAdminUser() {
//		userRepository.save(user);
		return "Welcome Admin user";
	}

}
