package com.example.hw49.service;

import com.example.hw49.dao.ResumeDao;
import com.example.hw49.dto.ResumeDto;
import com.example.hw49.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
                        .category(categoryService.getCategoryById(e.getCategoryId()))
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
                .category(categoryService.getCategoryById(resume.getCategoryId()))
                .authorEmail(resume.getAuthorEmail())
                .educations(educationService.findEducationById(resume.getId()))
                .experiences(experienceService.findExperienceById(resume.getId()))
                .active(resume.isActive())
                .build();
    }

    public void deleteResume(Long resumeId) {
        resumeDao.deleteResume(resumeId);
    }

    public void createResume(ResumeDto resumeDto) {
        Resume.builder()
                .title(resumeDto.getTitle())
                .requiredSalary(resumeDto.getRequiredSalary())
                .authorEmail(resumeDto.getAuthorEmail())
//                 .educations(educationService.createNewEducation();)
//                  .experiences(experienceService)
//                  .category(categoryService)
                .build();
    }

    public void changeResume(ResumeDto resumeDto) {
        resumeDao.changeResume(Resume.builder()
                .title(resumeDto.getTitle())
//                .categoryId(resumeDto.getCategory().getId())
                .requiredSalary(resumeDto.getRequiredSalary())
                .authorEmail(resumeDto.getAuthorEmail())
//                .experienceId(resumeDto.getExperiences().getId())
//                .educationId(resumeDto.getEducations().getId())
                .active(resumeDto.isActive())
                .id(resumeDto.getId())
                .build());
    }
}
