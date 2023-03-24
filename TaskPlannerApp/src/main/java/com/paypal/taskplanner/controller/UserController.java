package com.paypal.taskplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.taskplanner.exception.UserException;
import com.paypal.taskplanner.model.Task;
import com.paypal.taskplanner.model.User;
import com.paypal.taskplanner.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService uService;

	@PostMapping("/adduser")
	public ResponseEntity<User> createUser(@RequestBody User user) throws UserException
	{
		return new ResponseEntity<User>(uService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/all/task")
	public ResponseEntity<List<Task>> getAllTaskByUser(@RequestParam("uid") Long userid) throws UserException
	{
		return new ResponseEntity<>(uService.getAllTaskByUser(userid), HttpStatus.CREATED);
	}
}
