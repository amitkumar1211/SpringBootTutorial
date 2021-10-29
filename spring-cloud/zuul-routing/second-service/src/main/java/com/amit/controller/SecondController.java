package com.amit.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class SecondController {

	@GetMapping("/message")
	public String test(@RequestHeader("second-request") String header) {
		System.out.println(header);
		return "Hello called in second Service";
	}

}
