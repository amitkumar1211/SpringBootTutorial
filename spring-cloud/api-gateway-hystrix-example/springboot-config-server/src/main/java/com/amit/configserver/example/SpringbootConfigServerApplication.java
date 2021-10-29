package com.amit.configserver.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableConfigServer
@EnableDiscoveryClient
public class SpringbootConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigServerApplication.class, args);
	}

}
