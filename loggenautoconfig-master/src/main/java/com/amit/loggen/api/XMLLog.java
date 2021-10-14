package com.amit.loggen.api;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class XMLLog implements LogApi {

	@Override
	public void generate(String name) {
		// TODO Auto-generated method stub

		System.out.println("Generating XML log file ..."+name+".xml");
		
	}

}
