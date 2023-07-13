package com.example.hw49.entity;

import lombok.Data;

@Data
public class Resume {
    private Long id;
    private String jobTitle;
    private double requiredSalary;
    private boolean active;
    private String authorEmail;
    private Long experienceId;
    private Long educationId;
    private Long categoryId;
}
