package com.finna.be.octo.avenger.core.db.model;

public enum ActionType {

	INSERT(1), UPDATE(2);
	
	private int value;
	
	private ActionType(int value) {
		this.value = value;
	}
	
}
