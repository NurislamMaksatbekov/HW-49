package com.example.hw49.dto;

import lombok.*;

import java.time.LocalDateTime;
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
    private ContactDto contact;
    private List<ExperienceDto> experiences;
    private List<EducationDto> educations;
    private LocalDateTime dateOfPosted;
    private LocalDateTime dateOfUpdated;
}
