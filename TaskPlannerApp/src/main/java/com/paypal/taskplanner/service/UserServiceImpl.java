package com.paypal.taskplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.taskplanner.dao.UserDao;
import com.paypal.taskplanner.model.User;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDao uDao;

	@Override
	public User createUser(User user)
	{
		return uDao.save(user);
	}

}
