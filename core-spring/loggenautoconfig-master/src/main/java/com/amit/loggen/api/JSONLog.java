package com.amit.loggen.api;

public class JSONLog implements LogApi {

	@Override
	public void generate(String name) {
		// TODO Auto-generated method stub
		System.out.println("Generating JSON log file ..."+name+".json");

	}

}
