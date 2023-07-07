package com.example.hw49.entity;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String post;
    private double requiredSalary;
    private String experience;
    private String education;
    private Contact contacts;
}
