package com.google.common.webSocket.client;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@ClientEndpoint
public class ClientWebsocket {
	private final static Logger logger = LoggerFactory.getLogger(ClientWebsocket.class);
	Session session = null;

	public ClientWebsocket() {
		super();
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		try {
			container.connectToServer(this, new URI("ws://localhost:8080/mapWebsocket"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;

	}

	@OnClose
	public void onClose() {
		logger.info("java client关闭了连接！");
		this.session = null;

	}

	@OnMessage
	public void onMessage(String message, Session session) {
		logger.info("收到广播！");

	}

	@OnError
	public void onError(Throwable e) {
		logger.info("遇到错误了: {}",e.getMessage());

	}

	public void sendMessage(String message) {
		this.session.getAsyncRemote().sendText(message);
	}
}
