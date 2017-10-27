package com.google.common.webSocket.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class SimpleClientWebSocketHandler extends TextWebSocketHandler{
	
	protected Logger logger = LoggerFactory.getLogger(SimpleClientWebSocketHandler.class);

	/*private final GreetingService greetingService;

	private final CountDownLatch latch;

	private final AtomicReference<String> messagePayload;

	public SimpleClientWebSocketHandler(GreetingService greetingService,
			CountDownLatch latch, AtomicReference<String> message) {
		this.greetingService = greetingService;
		this.latch = latch;
		this.messagePayload = message;
	}
	*/

	public SimpleClientWebSocketHandler() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		TextMessage message = new TextMessage("1111");
		session.sendMessage(message);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		//this.logger.info("Received: " + message + " (" + this.latch.getCount() + ")");
		session.close();
	/*	this.messagePayload.set(message.getPayload());
		this.latch.countDown();*/
	}

}
