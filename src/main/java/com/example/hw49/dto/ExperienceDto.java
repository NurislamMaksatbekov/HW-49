package com.example.hw49.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExperienceDto {
    private String workPeriod;
    private String responsibilities;
    private String companyName;
}
