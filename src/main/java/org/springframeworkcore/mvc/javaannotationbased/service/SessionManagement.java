package org.springframeworkcore.mvc.javaannotationbased.service;

import java.util.Map;

import org.springframeworkcore.mvc.javaannotationbased.session.model.SessionData;

public interface SessionManagement {
	public void saveSession(String sessionId, String username, boolean remember);
	public Map getSession(String sessionId);
	public void deleteSession(String sessionId);
}
