package com.example.hw49.controller;

import com.example.hw49.dto.VacancyDto;
import com.example.hw49.service.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacancies")
public class VacancyController {
    private final VacancyService vacancyService;

    @GetMapping
    public List<VacancyDto> getAllVacancies() {
        return vacancyService.findAllVacancies();
    }

    @GetMapping("/category")
    public List<VacancyDto> findVacancyByCategory(@RequestParam Long categoryId) {
        return vacancyService.getVacancyByCategory(categoryId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createVacancy(@Valid @RequestBody VacancyDto vacancy, Authentication auth) {
        vacancyService.saveVacancy(vacancy, auth);
        return ResponseEntity.ok("Вы успешно добавили вакансию");
    }

    @PostMapping("/change")
    public ResponseEntity<String> changeVacancy(@Valid @RequestBody VacancyDto vacancyDto, Authentication auth) {
        vacancyService.change(vacancyDto, auth);
        return ResponseEntity.ok("Вы успешно изменили вакансию");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteVacancy(@RequestParam Long vacancyId, Authentication auth) {
        vacancyService.deleteVacancy(vacancyId, auth);
        return ResponseEntity.ok("Вы успешно удалили вакансию");
    }

    @GetMapping("/my-vacancies")
    public List<VacancyDto> myVacancies(Authentication auth) {
        return vacancyService.myVacancies(auth);
    }

}
