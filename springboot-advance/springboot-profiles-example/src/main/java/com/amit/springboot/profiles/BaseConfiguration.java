package com.amit.springboot.profiles;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class BaseConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(BaseConfiguration.class);

  @PostConstruct
  void postConstruct() {
    logger.info("loaded BaseConfiguration!");
  }

  @Bean
  @Profile("uat")
  UatBean uatBean() {
    return new UatBean();
  }

}
