package com.example.hw49.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Resume {
    private Long id;
    private String title;
    private double requiredSalary;
    private boolean active;
    private String authorEmail;
    private Long categoryId;
    private LocalDateTime dateOfPosted;
    private LocalDateTime dateOfUpdated;
}


