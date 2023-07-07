package com.example.hw49.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobList {
    private Employer whoPosted;
    private Category category;
    private LocalDate date;

}
