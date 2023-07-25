package com.example.hw49.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private Long id;
    private String title;
    private double requiredSalary;
    private boolean active;
    private String authorEmail;
    private String category;
    private List<ExperienceDto> experiences;
    private List<EducationDto> educations;

}
