package com.amit.javaconfig.service;

public class TwitterService implements MessageService{

	public void sendMsg(String message) {
		System.out.println("twitter "+ message);
	}

}
