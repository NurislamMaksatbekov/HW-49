package com.example.hw49.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VacancyDto {
    private Long id;
    @NotBlank(message = "Заполните поле")
    private String title;
    @Min(value = 1, message = "Заполните поле")
    private double salary;
    private String authorEmail;
    @NotBlank(message = "Заполните поле")
    private String jobDescription;
    @Min(value = 1, message = "Заполните поле")
    private int requiredMinExperience;
    @Min(value = 1, message = "Заполните поле")
    private int requiredMaxExperience;
    private LocalDateTime dateOfPosted;
    private LocalDateTime dateOfUpdated;
    private boolean active;
    @NotBlank(message = "Заполните поле")
    private String category;
}
