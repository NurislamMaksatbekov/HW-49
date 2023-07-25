package com.example.hw49.service;

import com.example.hw49.dao.ResumeDao;
import com.example.hw49.dto.ResumeDto;
import com.example.hw49.entity.Education;
import com.example.hw49.entity.Experience;
import com.example.hw49.entity.Resume;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeDao resumeDao;
    private final CategoryService categoryService;
    private final EducationService educationService;
    private final ExperienceService experienceService;


    public List<ResumeDto> resumeDtoList(List<Resume> resumes) {
        return resumes.stream().map(e -> ResumeDto.builder()
                        .title(e.getTitle())
                        .requiredSalary(e.getRequiredSalary())
                        .category(categoryService.getTitleById(e.getCategoryId()))
                        .authorEmail(e.getAuthorEmail())
                        .experiences(experienceService.findExperienceById(e.getId()))
                        .educations(educationService.findEducationById(e.getId()))
                        .active(e.isActive())
                        .build())
                .toList();
    }

    public List<ResumeDto> findAllResumes() {
        List<Resume> resumes = resumeDao.findAllResumes();
        return resumeDtoList(resumes);
    }


    public List<ResumeDto> selectResumeByUser(String authorEmail) {
        List<Resume> resumes = resumeDao.selectResumesByUser(authorEmail);
        return resumeDtoList(resumes);
    }

    public List<ResumeDto> findResumeByTitle(String title) {
        List<Resume> resumes = resumeDao.findResumeByTitle(title);
        return resumeDtoList(resumes);
    }

    public ResumeDto findResumeById(Long resumeId) {
        Resume resume = resumeDao.findResumeById(resumeId);
        return ResumeDto.builder()
                .title(resume.getTitle())
                .requiredSalary(resume.getRequiredSalary())
                .category(categoryService.getTitleById(resume.getCategoryId()))
                .authorEmail(resume.getAuthorEmail())
                .educations(educationService.findEducationById(resume.getId()))
                .experiences(experienceService.findExperienceById(resume.getId()))
                .active(resume.isActive())
                .build();
    }

    public void deleteResume(Long resumeId) {
        log.info("Резюме удалено");
        resumeDao.delete(resumeId);
    }

    public void saveResume(ResumeDto resumeDto) {
        log.info("Резюме сохранено");
        var mayBeCategory = categoryService.getIdByTitle(resumeDto.getCategory().toUpperCase());

        Long categoryId;
        if (mayBeCategory.isPresent()) {
            categoryId = mayBeCategory.get().getId();
        } else {
            categoryId = categoryService.save(resumeDto.getCategory().toUpperCase());
        }

        Long resumeId = resumeDao.save(Resume.builder()
                .title(resumeDto.getTitle())
                .requiredSalary(resumeDto.getRequiredSalary())
                .authorEmail(resumeDto.getAuthorEmail())
                .categoryId(categoryId)
                .active(resumeDto.isActive())
                .build());

        resumeDto.getEducations().forEach(e -> educationService.save(Education.builder()
                .education(e.getEducation())
                .placeOfStudy(e.getPlaceOfStudy())
                .studyPeriod(e.getStudyPeriod())
                .resumeId(resumeId)
                .build()));

        resumeDto.getExperiences().forEach(e -> experienceService.save(Experience.builder()
                .companyName(e.getCompanyName())
                .workPeriod(e.getWorkPeriod())
                .responsibilities(e.getResponsibilities())
                .resumeId(resumeId)
                .build()));
    }

    public void changeResume(ResumeDto resumeDto) {
        log.info("Резюме изменено");
        resumeDao.change(ResumeDto.builder()
                .id(resumeDto.getId())
                .requiredSalary(resumeDto.getRequiredSalary())
                .authorEmail(resumeDto.getAuthorEmail())
                .active(resumeDto.isActive())
                .build());
    }
}


