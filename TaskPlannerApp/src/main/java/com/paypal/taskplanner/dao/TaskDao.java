package com.paypal.taskplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.taskplanner.model.Task;

public interface TaskDao  extends JpaRepository<Task, Long>{

}
