package com.amit.javaconfig.service;

public class EmailService implements MessageService{

	public void sendMsg(String message) {
		System.out.println("email " + message);
	}

}
