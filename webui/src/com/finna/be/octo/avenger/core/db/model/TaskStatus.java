package com.finna.be.octo.avenger.core.db.model;

public enum TaskStatus {

	INITIAL(1), IN_PROCESS(2), COMPLETED(3);
	
	private int value;
	
	private TaskStatus(int value) {
		this.value = value;
	}

}
