package org.taskTracker.backend.pojo;

import org.taskTracker.backend.exception.InvalidValueArgumentException;

public enum TaskStatus {
	INPROGRESS("In Progress"),
	NOTDONE("Not Done"), 
	DONE("Done");
	
	String status;
	
	private TaskStatus(String statusName) {
		this.status = statusName;
	}
	
	public String asString() {
		return this.status;
	}
	
	public static TaskStatus whichStatus(String input) throws InvalidValueArgumentException {
		for(TaskStatus taskStatus: TaskStatus.values())
			if(taskStatus.status.equalsIgnoreCase(input))
				return taskStatus;
		
		throw new InvalidValueArgumentException("Unexpected value: " + input);
	}
}
