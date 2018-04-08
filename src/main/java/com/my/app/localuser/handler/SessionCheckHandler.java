package com.my.app.localuser.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SessionCheckHandler extends TextWebSocketHandler {

	private static final Logger L = LoggerFactory.getLogger(SessionCheckHandler.class);

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		L.info("WebSocketSession connection -> {}", session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		L.info("WebSocketSession session closed -> {}", session);
	}

}
