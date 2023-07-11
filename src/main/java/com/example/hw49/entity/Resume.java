package com.example.hw49.entity;

import lombok.Data;

@Data
public class Resume {
    private Long id;
    private String jobTitle;
    private double requiredSalary;
    private String experience;
    private String titleOfCompany;
    private String responsibilities;
    private String education;
    private boolean active;
    private Long contacts;
    private String authorEmail;
    private Long categoryId;
}
