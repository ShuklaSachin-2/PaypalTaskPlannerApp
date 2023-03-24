package com.paypal.taskplanner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paypal.taskplanner.exception.UserException;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.model.User;

@Service
public interface UserService {
	public User createUser(User user);
	
	public List<Task> getAllTaskByUser(Long userId) throws UserException;
	
	
	
	
}
