package com.amit.springboot.profiles;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class UatBean {

  private static final Logger logger = LoggerFactory.getLogger(UatBean.class);

  @PostConstruct
  void postConstruct(){
    logger.info("loaded UAT!");
  }

}
