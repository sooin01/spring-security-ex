package com.my.app.localuser.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Service;

import com.my.app.localuser.domain.LocalUserDetail;

@Service
public class SessionDestoryedListener implements ApplicationListener<SessionDestroyedEvent> {

	private static final Logger L = LoggerFactory.getLogger(SessionDestoryedListener.class);

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(event.getTimestamp()));
		L.info("Session destroyed. Event id {}, timestamp: {}", event.getId(), timestamp);

		for (SecurityContext securityContext : event.getSecurityContexts()) {
			LocalUserDetail user = (LocalUserDetail) securityContext.getAuthentication().getPrincipal();
			String username = user.getUsername();

			L.info("Session destroyed! Event id: {}, username: {}", event.getId(), username);
		}
	}

}
