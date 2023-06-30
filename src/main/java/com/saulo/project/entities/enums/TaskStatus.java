package com.saulo.project.entities.enums;

public enum TaskStatus {
	
	INPROGRESS(1),
	COMPLETED(2),
	WAITING(3),
	STOPPED(4);
	
	private int code;
	
	private TaskStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TaskStatus valueOf(int code) {
		for(TaskStatus value: TaskStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid TaskStatus code!");
	}
}
