package org.taskTracker.backend.pojo;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.taskTracker.backend.annotation.JSONElement;
import org.taskTracker.backend.annotation.JSONObject;
import org.taskTracker.backend.exception.InvalidValueArgumentException;
import org.taskTracker.backend.warehouse.DataHolder;

@JSONObject
public class TaskPOJO implements Serializable {

	// SerialID
	private static final long serialVersionUID = -3082004746931148162L;

	/*
	 * 
	 * CLASS FIELD/S
	 * 
	 */

	private long id;
	private String taskName;
	private String date;
	private TaskStatus status;

	/*
	 * 
	 * CONSTRUCTORS
	 * 
	 */

	public TaskPOJO(Builder builder) {
		this.id = builder.id;
		this.taskName = builder.taskName;
		this.date = builder.date;
		this.status = builder.status;
	}

	/*
	 * 
	 * toString - Override
	 * 
	 */

	@Override
	public String toString() {
		return "TASK:: [ID=" + id + " | NAME=" + taskName + " | DATE=" + date + " | STATUS="+ status.asString() + "]";
	}

	/*
	 * 
	 * GETTER | SETTERS
	 * 
	 */

	@JSONElement(name = "ID")
	public final long getId() {
		return this.id;
	}
	
	@JSONElement(name = "Task Name")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@JSONElement(name = "Created on")
	public final String getDate() {
		return this.date;
	}
	
	@JSONElement(name = "Status")
	public final TaskStatus getStatus() {
		return status;
	}

	public final void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	public final void setStatus(String statusCode) throws InvalidValueArgumentException {
		this.status = TaskStatus.whichStatus(statusCode);
	}
	
	/*
	 * 
	 * BUILDER
	 * 
	 */

	public static class Builder {
		private String taskName;

		// Optional
		private long id = DataHolder.INSTANCE.getNewUID();
		private TaskStatus status = TaskStatus.NOTDONE;
		private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, YYYY"));

		public Builder(String name) {
			this.taskName = name;
		}

		public Builder setID(long id) {
			this.id = id;
			
			return this;
		}
		
		public Builder setDate(LocalDate date, Optional<String> pattern) {
			try {
			this.date = (pattern.isEmpty()) ? date.toString(): date.format(DateTimeFormatter.ofPattern(pattern.get()));
			
			}catch(IllegalArgumentException iae) {
				System.err.printf("""
									TaskPOJO::Builder.setDate::IllegalArgumentException
									Pattern was invalid => %s
								\n""", pattern.get());
				
			}catch(DateTimeException dte) {
				System.err.println("TaskPOJO::Builder.setDate::DateTimeException");
			} 
			
			return this;
		}
		
		public Builder setTaskStatus(TaskStatus status) {
			this.status = status;
			
			return this;
		}
		
		public TaskPOJO build() {
			return new TaskPOJO(this);
		}
	}
}
