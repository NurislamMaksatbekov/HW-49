package com.example.hw49.entity;

import lombok.Data;

@Data
public class ApplicantResume {
    private Long id;
    private String jobTitle;
    private double requiredSalary;
    private String experience;
    private String titleOfCompany;
    private String responsibilities;
    private String education;
    private Contact contacts;
    private Long authorId;
    private Long categoryId;
}
