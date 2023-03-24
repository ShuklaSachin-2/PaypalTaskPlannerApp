package com.paypal.taskplanner.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.enums.TaskType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private TaskType type;
    private TaskStatus status;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User assignee;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    
    @ManyToOne
    private Sprint sprint;

    // getters and setters
}

