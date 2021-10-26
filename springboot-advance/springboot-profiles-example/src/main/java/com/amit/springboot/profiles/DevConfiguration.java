package com.amit.springboot.profiles;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(DevConfiguration.class);

  @PostConstruct
  void postConstruct(){
    logger.info("loaded Dev Configuration!");
  }

}
