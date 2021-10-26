package com.amit.springboot.profiles;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("uat")
class UatPostContruct {

  private static final Logger logger = LoggerFactory.getLogger(UatPostContruct.class);

  @PostConstruct
  void postConstruct(){
    logger.info("loaded Post Contruct UAT bean!");
  }

}
