package com.example.hw49.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
public class ResumeDto {
    private Long id;
    private String jobTitle;
    private double requiredSalary;
    private boolean active;
    private UserDto authorEmail;
    private CategoryDto category;
    private List<ExperienceInfoDto> experiencesInfo;
    private List<EducationInfoDto> educationsInfo;
}
