package com.paypal.taskplanner.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.taskplanner.dao.TaskDao;
import com.paypal.taskplanner.dao.UserDao;
import com.paypal.taskplanner.exception.UserException;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.model.User;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private TaskDao tDao;

	@Override
	public User createUser(User user)
	{
		return uDao.save(user);
	}
	
	@Override
	public List<Task> getAllTaskByUser(Long userId) throws UserException
	{
//

		List<Task> tasks = tDao.findAll();

		List<Task> fiteredTasks = tasks.stream().filter(s -> s.getAssignee().getId() == userId)
				.collect(Collectors.toList());

		return fiteredTasks;

	}

}
