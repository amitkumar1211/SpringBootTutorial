package com.amit.nobanner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoBannerAppApplication {

	public static void main(String[] args) {
//		SpringApplication.run(NoBannerAppApplication.class, args);
		SpringApplication app = new SpringApplication(NoBannerAppApplication.class);
	    app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);
	}

}
