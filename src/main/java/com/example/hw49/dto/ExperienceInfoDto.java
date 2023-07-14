package com.example.hw49.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExperienceInfoDto {
    private Long id;
    private List<ExperienceDto> experiences;
}
