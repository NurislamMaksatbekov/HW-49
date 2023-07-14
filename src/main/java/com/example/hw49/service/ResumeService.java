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
    private final EducationInfoService educationInfoService;
    private final ExperienceInfoService experienceInfoService;

    public List<Resume> findResumeByCategory(Long id) {
        // Поиск резюме по категории
        return resumeDao.findResumeByCategory(id);
    }

    public List<Resume> selectResumeByUser(String authorEmail) {
        // Выборка созданных пользователем резюме
        return resumeDao.selectResumesByUser(authorEmail);
    }

    public Optional<Resume> findResumeById(Long resumeId) {
        return resumeDao.findResumeById(resumeId);
    }

    public void createResume(Resume resume) {
        var newResume = ResumeDto.builder()
                .title(resume.getTitle())
                .requiredSalary(resume.getRequiredSalary())
                .active(resume.isActive())
                .authorEmail(userService.findUserByEmail(resume.getAuthorEmail()))
                .educationsInfo(educationInfoService.getEducationByAuthor(resume.getAuthorEmail()))
                .experiencesInfo(experienceInfoService.getExperienceByAuthor(resume.getAuthorEmail()))
                .category(categoryService.getCategoryById(resume.getCategoryId()))
                .build();

//        resumeDao.createNewResume(newResume);
    }
}
