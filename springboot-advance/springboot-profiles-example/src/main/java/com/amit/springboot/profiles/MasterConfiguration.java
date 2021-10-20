package com.amit.springboot.profiles;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("master")
public class MasterConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(MasterConfiguration.class);
	
	@PostConstruct
	  void postConstruct(){
		logger.info("Hello from master configuration");
	  }
	

}
