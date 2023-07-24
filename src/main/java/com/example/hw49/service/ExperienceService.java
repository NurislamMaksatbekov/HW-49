package com.example.hw49.service;

import com.example.hw49.dao.ExperienceDao;
import com.example.hw49.dto.ExperienceDto;
import com.example.hw49.entity.Experience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceDao experienceDao;

    public List<ExperienceDto> findExperienceById(Long id){
        List<Experience> experience = experienceDao.getExperienceByResumeId(id);
        return experience.stream().map(e -> ExperienceDto.builder()
                .companyName(e.getCompanyName())
                .workPeriod(e.getWorkPeriod())
                .responsibilities(e.getResponsibilities())
                .build()).toList();
    }
}
