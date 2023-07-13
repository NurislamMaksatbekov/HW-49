package com.example.hw49.entity;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum Type {
    APPLICANT("Applicant"),
    EMPLOYER("Employer");

    private String type;


}
