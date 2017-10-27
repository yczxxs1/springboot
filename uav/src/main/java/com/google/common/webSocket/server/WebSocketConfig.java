package com.google.common.webSocket.server;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.common.webSocket.client.SimpleClientWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig  implements WebSocketConfigurer  {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		 registry.addHandler(new QuesstionHandle(), "/mapWebsocket").setAllowedOrigins("*");
		
	}

	@Bean
    public WebSocketHandler myHandler() {
        return new SimpleClientWebSocketHandler();
    }

	
	class QuesstionHandle extends TextWebSocketHandler{
		
		private List<WebSocketSession> sessions=new CopyOnWriteArrayList<>();

		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			// TODO Auto-generated method stub
			sessions.add(session);
		}

		@Override
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			// TODO Auto-generated method stub
			
			for(WebSocketSession s:sessions){
				s.sendMessage(message);
			}
		}

		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			// TODO Auto-generated method stub
			sessions.remove(session);
		}
		
		
	}	  

}