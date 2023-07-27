package com.example.hw49.dto;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VacancyDto {
    private Long id;
    private String title;
    private double salary;
    @Email
    private String authorEmail;
    private String jobDescription;
    private int requiredMinExperience;
    private int requiredMaxExperience;
    private LocalDateTime dateOfPosted;
    private LocalDateTime dateOfUpdated;
    private boolean active;
    private String category;
}
