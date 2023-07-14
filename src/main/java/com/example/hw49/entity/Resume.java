package com.example.hw49.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Resume {
    private Long id;
    private String title;
    private double requiredSalary;
    private boolean active;
    private String authorEmail;
    private Long experienceInfoId;
    private Long educationInfoId;
    private Long categoryId;
}
