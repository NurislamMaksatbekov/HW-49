package com.example.hw49.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResumeDto {
    private Long id;
    @NotBlank(message = "Заполните поле")
    private String title;
    @Min(value = 1)
    private double requiredSalary;
    private boolean active;
    private String authorEmail;
    @NotBlank(message = "Категория не может быть пустой")
    private String category;
    private ContactDto contact;
    private List<ExperienceDto> experiences;
    private List<EducationDto> educations;
    private LocalDateTime dateOfPosted;
    private LocalDateTime dateOfUpdated;
}
