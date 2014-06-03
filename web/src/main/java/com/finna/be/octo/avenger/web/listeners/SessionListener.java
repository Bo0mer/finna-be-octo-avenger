package com.finna.be.octo.avenger.web.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

	private SessionManager manager = SessionManager.getInstance();

	public void sessionCreated(HttpSessionEvent event) {
		manager.addSession(event.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		manager.removeSession(event.getSession());
	}

}
