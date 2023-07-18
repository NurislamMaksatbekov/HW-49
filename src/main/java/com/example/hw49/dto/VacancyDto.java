package com.example.hw49.dto;

import com.example.hw49.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private int requiredMinExp;
    private int requiredMaxExp;
    private LocalDate dateOfPosted;
    private LocalDate dateOfUpdated;
    private boolean active;
    private CategoryDto category;
}
