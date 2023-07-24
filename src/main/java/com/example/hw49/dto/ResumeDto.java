package com.example.hw49.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    @JsonIgnore
    private Long id;
    private String title;
    private double requiredSalary;
    private boolean active;
    private String authorEmail;
    private CategoryDto category;
    private List<ExperienceDto> experiences;
    private List<EducationDto> educations;

}
