package com.finna.be.octo.avenger.core.db.dao.impl;

public enum UserRole {
	ADMIN("admin"), USER("user");
	
	private String value;
	
	private UserRole(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
