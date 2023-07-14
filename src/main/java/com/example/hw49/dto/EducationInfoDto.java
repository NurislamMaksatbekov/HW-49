package com.example.hw49.dto;

import com.example.hw49.entity.Education;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EducationInfoDto {
    private List<Education> educations;
}
