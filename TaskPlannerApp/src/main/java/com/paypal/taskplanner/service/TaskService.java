package com.paypal.taskplanner.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.model.Sprint;
import com.paypal.taskplanner.model.Task;

public interface TaskService {

	
	public Sprint createSprint(Sprint sprint);
	
	 public Task createTask( Long sprintId,  Task task);
	 
	 public Task changeTaskAssignee( Long sprintId, Long taskId, String assignee);
	 
	 public Task changeTaskStatus( Long sprintId,  Long taskId,  TaskStatus status);
	 
	 public List<Task> getTasksInSprint(@PathVariable Long sprintId);
}
