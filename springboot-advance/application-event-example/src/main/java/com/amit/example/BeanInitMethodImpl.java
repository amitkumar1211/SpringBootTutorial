package com.amit.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class BeanInitMethodImpl {
	
	@Autowired
    private Environment environment;

    public void init() {
        System.out.println("BeanInitMethod "+Arrays.asList(environment.getDefaultProfiles()));
    }

}
