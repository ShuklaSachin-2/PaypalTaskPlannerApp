package com.paypal.taskplanner.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private String name;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    // getters and setters
}

