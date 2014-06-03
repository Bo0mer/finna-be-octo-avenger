package com.finna.be.octo.avenger.web.listeners;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

/**
 * Implementation of this class represents a singleton pattern (only one
 * instance of this class could be created). SessionManager keeps a map with all
 * active sessions created in the application.
 * 
 */
public class SessionManager {

	private static SessionManager manager = new SessionManager();

	private ConcurrentHashMap<HttpSession, String> sessions = new ConcurrentHashMap<HttpSession, String>();

	/**
	 * Use this method to get an instance of SessionManager class
	 * 
	 * @return an instance of SessionManager class
	 */
	public static SessionManager getInstance() {
		return manager;
	}

	private SessionManager() {

	}

	/**
	 * Get the map with active sessions.
	 * 
	 * @return the map with all active sessions
	 */
	public ConcurrentHashMap<HttpSession, String> getSessions() {
		return sessions;
	}

	/**
	 * Add a session to the map with active sessions. This method should be
	 * invoked whenever a session is created (when sessionCreated is invoked).
	 * 
	 * @param session
	 *            newly created session
	 */
	public void addSession(HttpSession session) {
		sessions.put(session, session.getId());
	}

	/**
	 * Removes a session from the map of active sessions. This method should be
	 * invoked when a session is invalidated/expired (when sessionDestroyed is
	 * invoked).
	 * 
	 * @param session
	 *            expired/invalidated session
	 */
	public void removeSession(HttpSession session) {
		sessions.remove(session);
	}

}
