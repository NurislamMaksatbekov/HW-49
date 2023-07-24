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
@RequestMapping("/vacancies")
public class EmployerController {
    private final VacancyService vacancyService;
    private final ResumeService resumeService;
    private final UserService userService;

    @GetMapping("/applicant/id/{vacancyId}")
    public List<UserDto> findUserByRespond(@PathVariable Long vacancyId) {
        return userService.getUserByResponds(vacancyId);
    }

    @GetMapping("/applicant/email/{email}")
    public UserDto findApplicant(@PathVariable String email) {
        return userService.findApplicant(email);
    }

    @GetMapping("/allResumes")
    public List<ResumeDto> findAllResumes() {
        return resumeService.findAllResumes();
    }

    @GetMapping("/resume/title/{title}")
    public List<ResumeDto> findResumeByTitle(@PathVariable String title) {
        return resumeService.findResumeByTitle(title);
    }

    @PostMapping("/newVacancy")
    public void createVacancy(@RequestBody VacancyDto vacancy) {
        vacancyService.createVacancy(vacancy);
    }

    @PostMapping("/vacancy")
    public void changeVacancy(@RequestBody VacancyDto vacancyDto) {
        vacancyService.changeVacancy(vacancyDto);
    }

    @DeleteMapping("/vacancy/id/{vacancyId}")
    public void deleteVacancy(@PathVariable Long vacancyId) {
        vacancyService.deleteVacancy(vacancyId);
    }


}

