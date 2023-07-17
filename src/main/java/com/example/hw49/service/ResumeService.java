package com.example.hw49.service;

import com.example.hw49.dao.ResumeDao;
import com.example.hw49.dto.ResumeDto;
import com.example.hw49.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeDao resumeDao;
    private final UserService userService;
    private final CategoryService categoryService;
    private final EducationService educationService;
    private final ExperienceService experienceService;

    public List<Resume> findResumeByCategory(Long id) {
        // Поиск резюме по категории
        return resumeDao.findResumeByCategory(id);
    }



    public List<ResumeDto> selectResumeByUser(String authorEmail) {
        // Выборка созданных пользователем резюме
        List<Resume> resumes = resumeDao.selectResumesByUser(authorEmail);
        return resumes.stream()
                .map(e -> ResumeDto.builder()
                        .id(e.getId())
                        .title(e.getTitle())
                        .requiredSalary(e.getRequiredSalary())
                        .category(categoryService.getCategoryById(e.getCategoryId()))
                        .authorEmail(userService.findUserByEmail(e.getAuthorEmail()))
                        .educations(educationService.findEducationById(e.getEducationId()))
                        .experiences(experienceService.findExperienceById(e.getExperienceId()))
                        .active(e.isActive())
                        .build())
                .toList();

    }

    public ResumeDto findResumeById(Long resumeId) {
         Resume resume = resumeDao.findResumeById(resumeId);
         return ResumeDto.builder()
                 .id(resume.getId())
                 .title(resume.getTitle())
                 .requiredSalary(resume.getRequiredSalary())
                 .category(categoryService.getCategoryById(resume.getCategoryId()))
                 .authorEmail(userService.findUserByEmail(resume.getAuthorEmail()))
                 .educations(educationService.findEducationById(resume.getEducationId()))
                 .experiences(experienceService.findExperienceById(resume.getExperienceId()))
                 .active(resume.isActive())
                 .build();

    }

    public void createResume(ResumeDto resumeDto) {
        resumeDao.createNewResume(Resume.builder()
                .title(resumeDto.getTitle())
                .categoryId(resumeDto.getCategory().getId())
                .requiredSalary(resumeDto.getRequiredSalary())
                .authorEmail(resumeDto.getAuthorEmail())
                .experienceId(resumeDto.getExperiences().getId())
                .educationId(resumeDto.getEducations().getId())
                .active(true)
                .build());

    }
}
