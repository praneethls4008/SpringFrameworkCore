package org.springframeworkcore.mvc.javaannotationbased.session.model;

import jakarta.validation.constraints.NotBlank;

public record SessionData(
		String sessionId, 
		String username, 
		String role, 
		long lastAccessTime
		)
{}