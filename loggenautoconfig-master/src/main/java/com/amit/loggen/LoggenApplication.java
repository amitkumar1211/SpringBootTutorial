package com.amit.loggen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amit.loggen.api.LogApi;

@SpringBootApplication
public class LoggenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggenApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(LogApi logapi) {
		
		return args -> { logapi.generate("dlog"); };
		
	}
	
}
