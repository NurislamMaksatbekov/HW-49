package com.example.hw49.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobList {
    private Long id;
    private Long authorId;
    private Long categoryId;
    private LocalDate dateOfPosted;

}
