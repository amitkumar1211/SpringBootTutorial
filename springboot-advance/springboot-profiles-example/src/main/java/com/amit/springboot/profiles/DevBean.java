package com.amit.springboot.profiles;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
@ConditionalOnProperty(value = "mock.enabled", havingValue = "false", matchIfMissing = true)
class DevBean {

  private static final Logger logger = LoggerFactory.getLogger(DevBean.class);

  @PostConstruct
  void postConstruct(){
    logger.info("loaded Dev Profile!");
  }

}
