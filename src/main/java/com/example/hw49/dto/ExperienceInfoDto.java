package com.example.hw49.dto;

import com.example.hw49.entity.Experience;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExperienceInfoDto {
    private List<Experience> experience;
}
