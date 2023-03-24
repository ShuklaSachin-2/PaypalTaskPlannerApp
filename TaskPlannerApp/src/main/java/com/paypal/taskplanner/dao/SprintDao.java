package com.paypal.taskplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.taskplanner.model.Sprint;

public interface SprintDao extends JpaRepository<Sprint	, Long> {

}
