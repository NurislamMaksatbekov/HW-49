package com.example.hw49.service;

import com.example.hw49.dao.EducationDao;
import com.example.hw49.dto.EducationDto;
import com.example.hw49.entity.Education;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationDao educationDao;

    public EducationDto findEducationById(Long id){
        Education education = educationDao.getEducationById(id);

        return EducationDto.builder()
                .id(education.getId())
                .education(education.getEducation())
                .studyPeriod(education.getStudyPeriod())
                .placeOfStudy(education.getPlaceOfStudy())
                .build();
    }
}
