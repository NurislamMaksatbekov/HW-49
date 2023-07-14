package com.example.hw49.entity;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Vacancy {
    private Long id;
    private String title;
    private double salary;
    private String jobDescription;
    private int requiredMinExp;
    private int requiredMaxExp;
    private LocalDate dateOfPosted;
    private LocalDate dateOfUpdated;
    private boolean active;
    private Long categoryId;
    private String authorEmail;
}
