package com.google.common.webSocket.client;

public class Client {
	
	  public static void main(String... argv) {
		 /*   WebSocketClient webSocketClient = new StandardWebSocketClient();
	        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
	        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
	        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

	        String url = "ws://127.0.0.0:8080/hello/";
	        StompSessionHandler sessionHandler = new SessionHandler();
	        stompClient.connect(url, sessionHandler);*/
		  ClientWebsocket cw=new ClientWebsocket();
		  cw.sendMessage("aaa");
		
	        //new Scanner(System.in).nextLine(); //Don't close immediately.
	    }
	
}
