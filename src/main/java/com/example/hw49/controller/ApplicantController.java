package com.example.hw49.controller;

import com.example.hw49.dto.ResumeDto;
import com.example.hw49.dto.UserDto;
import com.example.hw49.dto.VacancyDto;
import com.example.hw49.service.ResumeService;
import com.example.hw49.service.UserService;
import com.example.hw49.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resumes")
public class ApplicantController {
    private final ResumeService resumeService;
    private final VacancyService vacancyService;
    protected final UserService userService;

    @GetMapping("/resume/email/{authorEmail}")
    public List<ResumeDto> selectResumeByUser(@PathVariable String authorEmail){
        return resumeService.selectResumeByUser(authorEmail);
    }

    @GetMapping("/resume/id/{resumeId}")
    public ResumeDto findResumeById(@PathVariable Long resumeId){
        return resumeService.findResumeById(resumeId);
    }

    @PostMapping("/newResume")
    public void createResume(@RequestBody ResumeDto resumeDto){
        resumeService.createResume(resumeDto);
    }

    @PostMapping("/resume")
    public void changeResume(@RequestBody ResumeDto resume){
        resumeService.changeResume(resume);
    }

    @DeleteMapping("/resume/{resumeId}")
    public void deleteResume(@PathVariable Long resumeId){
        resumeService.deleteResume(resumeId);
    }

    @GetMapping("/allVacancies")
    public List<VacancyDto> getAllVacancies(){
        return vacancyService.findAllVacancies();
    }

    @GetMapping("/vacancyCategory/{categoryId}")
    public List<VacancyDto> findVacancyByCategory(@PathVariable Long categoryId){
        return vacancyService.getVacancyByCategory(categoryId);
    }

    @GetMapping("/employer/email/{email}")
    public UserDto findApplicant(@PathVariable String email) {
        return userService.findEmployer(email);
    }


}

