package com.example.hw49.entity;


import lombok.Data;

@Data
public class EmployerResume {
    private Long id;
    private String jobTitle;
    private double salary;
    private String jobDescription;
    private int requiredMaxExp;
    private int requiredMinExp;
    private Category category;
    private User user;
}
