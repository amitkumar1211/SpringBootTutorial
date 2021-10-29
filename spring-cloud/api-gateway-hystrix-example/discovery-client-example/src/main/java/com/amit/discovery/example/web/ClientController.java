package com.amit.discovery.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/call")
public class ClientController {
	

	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@GetMapping("/first")
	public String callService() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo info = eurekaClient.getNextServerFromEureka("first-microservice", false);
		String baseUrl = info.getHomePageUrl();
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl+"/employee/message", HttpMethod.GET, null, String.class);
		return responseEntity.getBody();
	}

}
