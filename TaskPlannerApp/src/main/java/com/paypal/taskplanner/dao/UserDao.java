package com.paypal.taskplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.taskplanner.model.User;

public interface UserDao extends JpaRepository<User, Long> {

}
