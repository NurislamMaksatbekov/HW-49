package com.example.hw49.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EducationDto {
    @JsonIgnore
    private Long id;
    private String education;
    private String placeOfStudy;
    private String studyPeriod;
}
