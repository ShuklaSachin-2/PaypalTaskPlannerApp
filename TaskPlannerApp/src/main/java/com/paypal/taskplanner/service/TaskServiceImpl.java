package com.paypal.taskplanner.service;

import java.util.ArrayList;



import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.paypal.taskplanner.dao.SprintDao;
import com.paypal.taskplanner.dao.TaskDao;
import com.paypal.taskplanner.dao.UserDao;
import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.exception.SprintException;
import com.paypal.taskplanner.exception.TaskException;
import com.paypal.taskplanner.exception.UserException;
import com.paypal.taskplanner.model.Sprint;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.model.User;

@Service
public class TaskServiceImpl implements TaskService {
	

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
	public Task createTask(Long sprintId,Long UserID, Task task) throws SprintException, UserException
	{
		Sprint sprint = sDao.findById(sprintId).orElseThrow(() -> new SprintException("sprint not found"));

		sprint.getTasks().add(task);
		
		task.setSprint(sprint);
		
		List<User> userslist = uDao.findAll().stream().filter(s -> s.getId() == UserID).collect(Collectors.toList());

		if (userslist.isEmpty())
		{
			throw new UserException("User Not FOund");
		}
		task.setAssignee(userslist.get(0));

		

		return tDao.save(task);
	}
	
	@Override
	public Task changeTaskAssignee(Long taskid, Long userid) throws UserException, TaskException{
		
		Task task = tDao.findById(taskid).orElseThrow(()->new TaskException("Task not found"));
		
		List<User> userList = uDao.findAll().stream().filter(s->s.getId()==userid).collect(Collectors.toList());
		
		if(userList.isEmpty()) {
			throw new UserException("user not found");
		}
		task.setAssignee(userList.get(0));
		return tDao.save(task);
		
	}

	
	@Override
	public Task changeTaskStatus(Long taskId, TaskStatus status) throws TaskException
	{
		Task task = tDao.findById(taskId).orElseThrow(() -> new TaskException("Task not found"));
		task.setStatus(status);

		return tDao.save(task);
	}

	@Override
	public List<Task> getTasksInSprint(Long sprintId) throws SprintException
	{

		return sDao.findById(sprintId).orElseThrow(() -> new SprintException("Sprint not found")).getTasks();
	}

}
