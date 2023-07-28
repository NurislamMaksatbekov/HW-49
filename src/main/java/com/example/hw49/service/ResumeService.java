package com.example.hw49.service;

import com.example.hw49.dao.ResumeDao;
import com.example.hw49.dto.EducationDto;
import com.example.hw49.dto.ExperienceDto;
import com.example.hw49.dto.ResumeDto;
import com.example.hw49.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeDao resumeDao;
    private final CategoryService categoryService;
    private final EducationService educationService;
    private final ExperienceService experienceService;
    private final ContactService contactService;


    public List<ResumeDto> resumeDtoList(List<Resume> resumes) {
        return resumes.stream().map(e -> ResumeDto.builder()
                        .id(e.getId())
                        .title(e.getTitle())
                        .requiredSalary(e.getRequiredSalary())
                        .category(categoryService.getTitleById(e.getCategoryId()))
                        .authorEmail(e.getAuthorEmail())
                        .experiences(experienceService.findExperienceById(e.getId()))
                        .educations(educationService.findEducationById(e.getId()))
                        .contact(contactService.getContactByResumeId(e.getId()))
                        .dateOfPosted(e.getDateOfPosted())
                        .dateOfUpdated(e.getDateOfUpdated())
                        .active(e.isActive())
                        .build())
                .toList();
    }

    public List<ResumeDto> myResumes(Authentication auth){
        User u = (User) auth.getPrincipal();
        List<Resume> resumes = resumeDao.myResumes(u.getUsername());
        return resumes.stream().map(e -> ResumeDto.builder()
                        .title(e.getTitle())
                        .requiredSalary(e.getRequiredSalary())
                        .category(categoryService.getTitleById(e.getCategoryId()))
                        .experiences(experienceService.findExperienceById(e.getId()))
                        .educations(educationService.findEducationById(e.getId()))
                        .contact(contactService.getContactByResumeId(e.getId()))
                        .dateOfPosted(e.getDateOfPosted())
                        .dateOfUpdated(e.getDateOfUpdated())
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
                .id(resume.getId())
                .title(resume.getTitle())
                .requiredSalary(resume.getRequiredSalary())
                .category(categoryService.getTitleById(resume.getCategoryId()))
                .authorEmail(resume.getAuthorEmail())
                .educations(educationService.findEducationById(resume.getId()))
                .experiences(experienceService.findExperienceById(resume.getId()))
                .contact(contactService.getContactByResumeId(resumeId))
                .dateOfPosted(resume.getDateOfPosted())
                .dateOfUpdated(resume.getDateOfUpdated())
                .active(resume.isActive())
                .build();
    }

    public void deleteResume(Long resumeId) {
        log.info("Резюме удалено");
        resumeDao.delete(resumeId);
    }

    public void saveResume(ResumeDto resumeDto, Authentication auth) {
        User u = (User) auth.getPrincipal();
        var mayBeCategory = categoryService.getIdByTitle(resumeDto.getCategory());

        Long categoryId;
        if (mayBeCategory.isEmpty()) {
            log.error("Выберите катергорию работы!");
        } else {
            categoryId = mayBeCategory.get().getId();

            Long resumeId = resumeDao.save(Resume.builder()
                    .title(resumeDto.getTitle().toUpperCase())
                    .requiredSalary(resumeDto.getRequiredSalary())
                    .authorEmail(u.getUsername())
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

            contactService.save(Contact.builder()
                    .contactValue(resumeDto.getContact().getContactValue())
                    .contactType(resumeDto.getContact().getContactType().toUpperCase())
                    .resumeId(resumeId)
                    .build());

            log.info(u.getUsername() + " добавил(а) резюме");
        }
    }

    public void changeResume(ResumeDto resumeDto) {
        log.info("Резюме изменено");

        var mayBeCategory = categoryService.getIdByTitle(resumeDto.getCategory());
        Long categoryId = mayBeCategory.get().getId();
        resumeDao.change(Resume.builder()
                .title(resumeDto.getTitle())
                .requiredSalary(resumeDto.getRequiredSalary())
                .active(resumeDto.isActive())
                .dateOfUpdated(LocalDateTime.now())
                .categoryId(categoryId)
                .id(resumeDto.getId())
                .build());

        Long resumeId = resumeDto.getId();


        List<EducationDto> educationDtoList = educationService.findEducationById(resumeId);
        educationService.change(educationDtoList.stream().map(e -> EducationDto.builder()
                        .education(e.getEducation())
                        .placeOfStudy(e.getPlaceOfStudy())
                        .studyPeriod(e.getStudyPeriod())
                        .id(e.getId())
                        .build())
                .toList());

        List<ExperienceDto> experienceDtoList = experienceService.findExperienceById(resumeId);
        experienceService.change(experienceDtoList.stream().map(e -> ExperienceDto.builder()
                        .companyName(e.getCompanyName())
                        .workPeriod(e.getWorkPeriod())
                        .responsibilities(e.getResponsibilities())
                        .id(e.getId())
                        .build())
                .collect(Collectors.toList()));
    }
}


