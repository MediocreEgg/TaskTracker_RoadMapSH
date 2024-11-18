package org.taskTracker.backend.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.taskTracker.backend.annotation.JSONElement;
import org.taskTracker.backend.annotation.JSONElementArray;
import org.taskTracker.backend.annotation.JSONObject;

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
	private LocalDate date;
	private TaskStatus status;
	private List<TaskPOJO> subTasks;

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
		this.subTasks = builder.subTasks;
	}

	/*
	 * 
	 * toString - Override
	 * 
	 */

	@Override
	public String toString() {
		return "TASK:: [ID=" + id + "] [NAME=" + taskName + "] [DATE=" + date + "] [STATUS="
				+ status.asString() + "] \n [subTasks=" + subTasks + "]\n";
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

	public final void setId(long id) {
		this.id = id;
	}

	@JSONElement(name = "Task Name")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@JSONElement(name = "Date")
	public final LocalDate getDate() {
		return this.date;
	}
	
	public final void setDate(long id) {
		this.id = id;
	}

	@JSONElement(name = "Status")
	public final TaskStatus getStatus() {
		return status;
	}

	public final void setStatus(TaskStatus status) {
		this.status = status;
	}

	@JSONElementArray(name = "Sub-Tasks")
	public final List<TaskPOJO> getSubTasks() {
		return subTasks;
	}

	public final void setSubTasks(List<TaskPOJO> subTasks) {
		this.subTasks = subTasks;
	}

	public final void addSubTask(TaskPOJO task) {
		if (Objects.isNull(subTasks))
			subTasks = new ArrayList<>();

		if (!Objects.isNull(task))
			this.subTasks.add(task);
	}

	public final void removeSubTask(TaskPOJO task) {
		if (!Objects.isNull(task) && !Objects.isNull(subTasks))
			this.subTasks.remove(task);
	}

	public final void removeSubTask(int index) {
		if (!Objects.isNull(subTasks))
			if (index < subTasks.size() || index >= 0)
				this.subTasks.remove(index);
	}

	/*
	 * 
	 * BUILDER
	 * 
	 */

	public static class Builder {
		private long id; // INT -> ID | STRING -> NAME | LOCALDATE -> DATE
		private String taskName;
		private LocalDate date;
		private TaskStatus status;

		// Optional
		private List<TaskPOJO> subTasks;

		public Builder(long id, String name, LocalDate dateCreated, TaskStatus status) {
			this.id = id;
			this.taskName = name;
			this.date = dateCreated;
			this.status = status;
		}

		public Builder setsubTasksList(TaskPOJO... tasks) {
			if (Objects.isNull(tasks) || tasks.length <= 0)
				return this;

			for (TaskPOJO task : tasks)
				subTasks.add(task);

			return this;
		}

		public Builder setsubTasksList(Collection<TaskPOJO> collection) {
			if (Objects.isNull(collection) || collection.isEmpty())
				return this;

			collection.forEach(subTasks::add);
			return this;
		}

		public TaskPOJO build() {
			return new TaskPOJO(this);
		}
	}
}
