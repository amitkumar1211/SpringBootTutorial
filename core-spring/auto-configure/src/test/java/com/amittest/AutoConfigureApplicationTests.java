package com.amittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amit.AutoConfigureApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AutoConfigureApplication.class)
@WebAppConfiguration
public class AutoConfigureApplicationTests {

	@Test
	public void contextLoads() {
	}

}
