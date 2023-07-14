package com.example.hw49.service;

import com.example.hw49.dao.ExperienceInfoDao;
import com.example.hw49.dto.ExperienceInfoDto;
import com.example.hw49.entity.ExperienceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceInfoService {
    private final ExperienceInfoDao experienceInfoDao;

    public List<ExperienceInfoDto> getExperienceByAuthor(String email) {
        List<ExperienceInfoDto> experienceInfoList = experienceInfoDao.getExperienceByAuthor(email);

        return experienceInfoList.stream()
                .map(e -> ExperienceInfoDto.builder()
                        .experience(e.getExperience())
                        .build())
                .collect(Collectors.toList());
    }
}
