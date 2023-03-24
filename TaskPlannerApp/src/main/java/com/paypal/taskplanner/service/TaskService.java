package com.paypal.taskplanner.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.exception.SprintException;
import com.paypal.taskplanner.exception.TaskException;
import com.paypal.taskplanner.exception.UserException;
import com.paypal.taskplanner.model.Sprint;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.model.User;

public interface TaskService {

	
	public Sprint createSprint(Sprint sprint);
	
	
	 public Task createTask( Long sprintId,Long userID,  Task task)throws SprintException,UserException;
	 
	 public Task changeTaskAssignee(Long taskid, Long userid) throws UserException, TaskException;
	 
	 public Task changeTaskStatus(Long taskId, TaskStatus status) throws TaskException;
	 
	 public List<Task> getTasksInSprint(Long sprintId) throws SprintException;
}
