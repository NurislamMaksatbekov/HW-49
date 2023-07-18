package com.example.hw49.controller;

import com.example.hw49.dto.VacancyDto;
import com.example.hw49.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacancies")
public class VacancyController {
    private final VacancyService vacancyService;

    @PostMapping("/createVacancy")
    public void createVacancy(@RequestBody VacancyDto vacancy){
        vacancyService.createVacancy(vacancy);
    }

    @PostMapping("/changeVacancy")
    public void changeVacancy(@RequestBody VacancyDto vacancyDto){
        vacancyService.changeVacancy(vacancyDto);
    }

    @DeleteMapping("/deleteVacancy/{vacancyId}")
    public void deleteVacancy(@PathVariable Long vacancyId){
        vacancyService.deleteVacancy(vacancyId);
    }

}

