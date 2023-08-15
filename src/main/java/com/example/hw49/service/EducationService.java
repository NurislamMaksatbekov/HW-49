package com.example.hw49.service;

import com.example.hw49.dao.EducationDao;
import com.example.hw49.dto.EducationDto;
import com.example.hw49.entity.Education;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationDao educationDao;

    public List<EducationDto> findEducationsById(Long id) {
        List<Education> education = educationDao.getEducationsById(id);
        return education.stream().map(e -> EducationDto.builder()
                .id(e.getId())
                .education(e.getEducation())
                .studyPeriod(e.getStudyPeriod())
                .placeOfStudy(e.getPlaceOfStudy())
                .build()).toList();
    }

    public EducationDto findEducationById(Long id){
        Education education = educationDao.getEducationById(id);
        return EducationDto.builder()
                .id(education.getId())
                .education(education.getEducation())
                .studyPeriod(education.getStudyPeriod())
                .placeOfStudy(education.getPlaceOfStudy())
                .build();
    }

    public Long save(Education education) {
        return educationDao.save(education);
    }


    public void change(EducationDto educationDto) {
        educationDao.getEducationById(educationDto.getResumeId());
            educationDao.change(Education.builder()
                    .education(educationDto.getEducation())
                    .studyPeriod(educationDto.getStudyPeriod())
                    .placeOfStudy(educationDto.getPlaceOfStudy())
                    .id(educationDto.getId())
                    .resumeId(educationDto.getResumeId())
                    .build());
    }
}
