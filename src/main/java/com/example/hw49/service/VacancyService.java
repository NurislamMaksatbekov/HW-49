package com.example.hw49.service;

import com.example.hw49.dao.VacancyDao;
import com.example.hw49.dto.VacancyDto;
import com.example.hw49.entity.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {
    private final VacancyDao vacancyDao;

    private List<VacancyDto> vacancyDtoList(List<Vacancy> vacancies) {
        return vacancies.stream().map(e -> VacancyDto.builder()
                .title(e.getTitle())
                .salary(e.getSalary())
                .authorEmail(e.getAuthorEmail())
                .jobDescription(e.getJobDescription())
                .requiredMinExp(e.getRequiredMinExp())
                .requiredMaxExp(e.getRequiredMaxExp())
                .dateOfPosted(e.getDateOfPosted())
                .dateOfUpdated(e.getDateOfUpdated())
                .active(e.isActive())
//                .category(categoryService.getCategoryById(e.getCategoryId()))
                .build()).toList();
    }

    public List<VacancyDto> getVacancyByCategory(Long categoryId) {
        List<Vacancy> vacancies = vacancyDao.getVacancyByCategory(categoryId);
        return vacancyDtoList(vacancies);
    }

    public void deleteVacancy(Long vacancyId) {
        vacancyDao.deleteVacancy(vacancyId);
    }

    public List<VacancyDto> findAllVacancies() {
        List<Vacancy> vacancies = vacancyDao.getAllVacancy();
        return vacancyDtoList(vacancies);
    }

    public void createVacancy(VacancyDto vacancyDto) {
        vacancyDao.createVacancy(Vacancy.builder()
                .title(vacancyDto.getTitle())
                .salary(vacancyDto.getSalary())
                .authorEmail(vacancyDto.getAuthorEmail())
                .jobDescription(vacancyDto.getJobDescription())
                .requiredMinExp(vacancyDto.getRequiredMinExp())
                .requiredMaxExp(vacancyDto.getRequiredMaxExp())
                .dateOfPosted(vacancyDto.getDateOfPosted())
                .dateOfUpdated(vacancyDto.getDateOfUpdated())
                .active(vacancyDto.isActive())
                .categoryId(vacancyDto.getCategory().getId())
                .build());
    }

    public void changeVacancy(VacancyDto vacancyDto) {
        vacancyDao.changeVacancy(Vacancy.builder()
                .title(vacancyDto.getTitle())
                .salary(vacancyDto.getSalary())
                .authorEmail(vacancyDto.getAuthorEmail())
                .jobDescription(vacancyDto.getJobDescription())
                .requiredMinExp(vacancyDto.getRequiredMinExp())
                .requiredMaxExp(vacancyDto.getRequiredMaxExp())
                .dateOfPosted(vacancyDto.getDateOfPosted())
                .dateOfUpdated(vacancyDto.getDateOfUpdated())
                .active(vacancyDto.isActive())
                .categoryId(vacancyDto.getCategory().getId())
                .id(vacancyDto.getId())
                .build());
    }
}
