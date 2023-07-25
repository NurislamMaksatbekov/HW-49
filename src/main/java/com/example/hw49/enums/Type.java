package com.example.hw49.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum Type {
    APPLICANT("Applicant"),
    EMPLOYER("Employer");

    private final String type;


}
