package com.example.hw49.service;

import com.example.hw49.dao.ExperienceDao;
import com.example.hw49.dto.ExperienceDto;
import com.example.hw49.entity.Experience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceDao experienceDao;

    public ExperienceDto findExperienceById(Long id){
        Experience experience = experienceDao.getExperienceById(id);
        return ExperienceDto.builder()
                .id(experience.getId())
                .companyName(experience.getCompanyName())
                .workPeriod(experience.getWorkPeriod())
                .responsibilities(experience.getResponsibilities())
                .build();
    }
}
