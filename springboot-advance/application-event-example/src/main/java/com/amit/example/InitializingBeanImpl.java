package com.amit.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanImpl implements InitializingBean {

	public InitializingBeanImpl() {
        System.out.println("InitializingBeanImpl Constructor called");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeanImpl afterPropertiesSet method called");
    }

}
