package com.amit.javaconfig.service;

public class SMSService implements MessageService{

	public void sendMsg(String message) {
		System.out.println("sms " + message);
	}

}
