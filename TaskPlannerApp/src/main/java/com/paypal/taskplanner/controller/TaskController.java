package com.paypal.taskplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.taskplanner.model.Sprint;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	
	
	@Autowired
	private TaskService tService;

    @PostMapping("/sprints")
    public Sprint createSprint(@RequestBody Sprint sprint) {
    	
        return tService.createSprint(sprint);
    }

//    @PostMapping("/sprints/{sprintId}/tasks")
//    public Task createTask(@PathVariable Long sprintId, @RequestBody Task task) {
//        Sprint sprint = getSprint(sprintId);
//        if (sprint == null) {
//            throw new NotFoundException("Sprint not found");
//        }
//
//        task.setId((long) (sprint.getTasks().size() + 1));
//        sprint.getTasks().add(task);
//        return task;
//    }
//
//    @PutMapping("/sprints/{sprintId}/tasks/{taskId}/assignee")
//    public Task changeTaskAssignee(@PathVariable Long sprintId, @PathVariable Long taskId, @RequestParam String assignee) {
//        Sprint sprint = getTasksInSprint(sprintId);
//        if (sprint == null) {
//            throw new NotFoundException("Sprint not found");
//        }
//
//        Task task = getTask(sprint, taskId);
//        if (task == null) {
//            throw new NotFoundException("Task not found");
//        }
//
//        task.setAssignee(assignee);
//        return task;
//    }
//
//    @PutMapping("/sprints/{sprintId}/tasks/{taskId}/status")
//    public Task changeTaskStatus(@PathVariable Long sprintId, @PathVariable Long taskId, @RequestParam TaskStatus status) {
//        Sprint sprint = getSprint(sprintId);
//        if (sprint == null) {
//            throw new NotFoundException("Sprint not found");
//        }
//
//        Task task = getTask(sprint, taskId);
//        if (task == null) {
//            throw new NotFoundException("Task not found");
//        }
//
//        task.setStatus(status);
//        return task;
    }

//  



