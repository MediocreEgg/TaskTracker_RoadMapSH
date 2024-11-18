package org.taskTracker.backend.pojo;

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
	
	public TaskStatus whichStatus(String input) {
		for(TaskStatus taskStatus: TaskStatus.values())
			if(taskStatus.status.equalsIgnoreCase(input))
				return taskStatus;
		
		return null;
	}
}
