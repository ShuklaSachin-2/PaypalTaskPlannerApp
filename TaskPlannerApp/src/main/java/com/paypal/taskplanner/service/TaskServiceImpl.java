package com.paypal.taskplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.taskplanner.dao.SprintDao;
import com.paypal.taskplanner.dao.TaskDao;
import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.model.Sprint;
import com.paypal.taskplanner.model.Task;

@Service
public class TaskServiceImpl implements TaskService {
	
//  private final List<Task> tasks = new ArrayList<>();
//  private final List<Sprint> sprints = new ArrayList<>();
	
	@Autowired
	private SprintDao sDao;
	
	@Autowired
	private TaskDao tDao;

	@Override
	public Sprint createSprint(Sprint sprint) {
		// TODO Auto-generated method stub
		
		sprint.setId((long) (sprints.size() + 1));
        sprints.add(sprint);
		return sprint;
	}

	@Override
	public Task createTask(Long sprintId, Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task changeTaskAssignee(Long sprintId, Long taskId, String assignee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task changeTaskStatus(Long sprintId, Long taskId, TaskStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksInSprint(Long sprintId) {
		// TODO Auto-generated method stub
		return null;
	}

}
