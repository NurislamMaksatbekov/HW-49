package com.example.hw49.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacancyDto {
    private Long id;
    private String title;
    private double salary;
    private String authorEmail;
    private String jobDescription;
    private int requiredMinExperience;
    private int requiredMaxExperience;
    private LocalDateTime dateOfPosted;
    private LocalDateTime dateOfUpdated;
    private boolean active;
    private String category;
}
