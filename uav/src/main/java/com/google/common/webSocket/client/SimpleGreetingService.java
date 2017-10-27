package com.google.common.webSocket.client;

public class SimpleGreetingService implements GreetingService{

	@Override
	public String getGreeting() {
		return "Hello world!";
	}
}
