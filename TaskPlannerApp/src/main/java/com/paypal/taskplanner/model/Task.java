package com.paypal.taskplanner.model;

import java.time.LocalDateTime;

import com.paypal.taskplanner.enums.TaskStatus;
import com.paypal.taskplanner.enums.TaskType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
    private Long id;
    private String title;
    private String description;
    private TaskType type;
    private TaskStatus status;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private User assignee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @ManyToMany
    private Sprint sprint;

    // getters and setters
}

