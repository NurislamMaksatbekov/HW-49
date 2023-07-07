package com.example.hw49.entity;


import lombok.Data;

@Data
public class Employer {
    private Long id;
    private String jobTitle;
    private double salary;
    private String jobDescription;
    private String requiredExp;

    private Category category;
}
