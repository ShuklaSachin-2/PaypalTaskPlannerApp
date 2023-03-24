package com.paypal.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.taskplanner.exception.UserException;
import com.paypal.taskplanner.model.User;
import com.paypal.taskplanner.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService uService;

	@PostMapping("/adduser")
	public ResponseEntity<User> createUser(@RequestBody User user) throws UserException
	{
		return new ResponseEntity<>(uService.createUser(user), HttpStatus.CREATED);
	}
}
