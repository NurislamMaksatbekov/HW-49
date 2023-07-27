package com.example.hw49.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExperienceDto {
    private Long id;
    private String workPeriod;
    private String responsibilities;
    private String companyName;
}
