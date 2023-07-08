package com.example.hw49.entity;

import lombok.Data;

@Data
public class EmployeeResume {
    private Long id;
    private String jobTitle;
    private double requiredSalary;
    private String experience;
    private String education;
    private Contact contacts;
    private User user;
}
