package com.example.hw49.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EducationInfoDto {
    private Long id;
    private List<EducationDto> educations;
}
