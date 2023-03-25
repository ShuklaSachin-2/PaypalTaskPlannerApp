package com.paypal.taskplanner.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.exception.SprintException;
import com.paypal.taskplanner.exception.TaskException;
import com.paypal.taskplanner.exception.UserException;
import com.paypal.taskplanner.model.Sprint;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.model.User;
import com.paypal.taskplanner.service.TaskService;

@RestController

@CrossOrigin("*")
public class TaskController {

	
	
	@Autowired
	private TaskService tService;

    @PostMapping("/addsprint")
    public Sprint createSprint(@RequestBody Sprint sprint) {
    	
        return tService.createSprint(sprint);
    }
    
 

	@PostMapping("/addtask/{sid}")
	public ResponseEntity<Task> createTask(@PathVariable("sid") Long sprintId,@RequestParam("uid") Long userId ,@RequestBody Task task)
			throws SprintException, UserException
	{
		return new ResponseEntity<>(tService.createTask(sprintId, userId, task), HttpStatus.CREATED);
	}
	
	@PostMapping("/changetaskassignee/{tid}")
	public ResponseEntity<Task> changetaskassignee(@PathVariable("tid") Long taskid,@RequestParam("uid") Long userId )
			throws SprintException, UserException, TaskException
	{
		return new ResponseEntity<>(tService.changeTaskAssignee(taskid, userId), HttpStatus.CREATED);
	}
	

	
	
	@PatchMapping("/statuschange/{tid}")
	public ResponseEntity<Task> changeTaskStatus(@PathVariable("tid") Long taskid,
			@RequestParam("status") TaskStatus status) throws UserException, TaskException
	{
		return new ResponseEntity<>(tService.changeTaskStatus(taskid, status), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all/{spid}")
	public ResponseEntity<List<Task>> getTasksInSprint(@PathVariable("spid") Long sprintId) throws SprintException
	{
		return new ResponseEntity<>(tService.getTasksInSprint(sprintId), HttpStatus.CREATED);
	}
	
	
	

}


