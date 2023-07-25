package com.example.hw49.entity;


import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Vacancy {
    private Long id;
    private String title;
    private double salary;
    private String jobDescription;
    private int requiredMinExperience;
    private int requiredMaxExperience;
    private LocalDate dateOfPosted;
    private LocalDate dateOfUpdated;
    private boolean active;
    private Long categoryId;
    private String authorEmail;
}
