package com.example.hw49.controller;

import com.example.hw49.dto.VacancyDto;
import com.example.hw49.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacancies")
public class VacancyController {
    private final VacancyService vacancyService;

    @GetMapping
    public List<VacancyDto> getAllVacancies(){
        return vacancyService.findAllVacancies();
    }

    @GetMapping("/category")
    public List<VacancyDto> findVacancyByCategory(@RequestParam Long categoryId){
        return vacancyService.getVacancyByCategory(categoryId);
    }

    @PostMapping("/create")
    public void createVacancy(@RequestBody VacancyDto vacancy, Authentication auth) {
        vacancyService.saveVacancy(vacancy, auth);
    }

    @PostMapping("/change")
    public void changeVacancy(@RequestBody VacancyDto vacancyDto) {
        vacancyService.change(vacancyDto);
    }

    @DeleteMapping("/delete")
    public void deleteVacancy(@RequestParam Long vacancyId) {
        vacancyService.deleteVacancy(vacancyId);
    }

    @GetMapping("/my-vacancies")
    public List<VacancyDto> myVacancies(Authentication auth){
        return vacancyService.myVacancies(auth);
    }
}
