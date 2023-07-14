package com.example.hw49.service;

import com.example.hw49.dao.EducationInfoDao;
import com.example.hw49.dto.EducationInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationInfoService {
    private final EducationInfoDao educationInfoDao;

    public List<EducationInfoDto> getEducationByAuthor(String email) {
        List<EducationInfoDto> educationInfo = educationInfoDao.getEducationByAuthor(email);
        return educationInfo.stream()
                .map(e -> EducationInfoDto.builder()
                        .educations(e.getEducations())
                        .build()).toList();
    }
}
