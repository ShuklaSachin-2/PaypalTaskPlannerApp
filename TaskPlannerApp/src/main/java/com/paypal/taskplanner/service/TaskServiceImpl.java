package com.paypal.taskplanner.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.paypal.taskplanner.dao.SprintDao;
import com.paypal.taskplanner.dao.TaskDao;
import com.paypal.taskplanner.dao.UserDao;
import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.exception.SprintException;
import com.paypal.taskplanner.model.Sprint;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.model.User;

@Service
public class TaskServiceImpl implements TaskService {
	
//  private final List<Task> tasks = new ArrayList<>();
//  private final List<Sprint> sprints = new ArrayList<>();
	
	@Autowired
	private SprintDao sDao;
	
	@Autowired
	private TaskDao tDao;
	
	@Autowired
	private UserDao uDao;

	@Override
	public Sprint createSprint(Sprint sprint) {
		// TODO Auto-generated method stub
		
		return sDao.save(sprint);
		
	}
	


	@Override
	public Task createTask(Long sprintId,Long UserID, Task task) throws SprintException
	{
		Sprint sprint = sDao.findById(sprintId).orElseThrow(() -> new SprintException("sprint not found"));

		sprint.getTasks().add(task);
		
		task.setSprint(sprint);

		return tDao.save(task);
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
