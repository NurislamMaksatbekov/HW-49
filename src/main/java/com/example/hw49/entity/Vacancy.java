package com.example.hw49.entity;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Vacancy {
    private Long id;
    private String jobTitle;
    private double salary;
    private String jobDescription;
    private int requiredMaxExp;
    private int requiredMinExp;
    private LocalDate dateOfPosted;
    private Long categoryId;
    private Long authorId;
}
