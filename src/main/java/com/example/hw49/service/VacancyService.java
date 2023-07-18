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

    public List<Vacancy> getVacancyByResponds(String authorEmail) {
        // Выборка вакансий на которые откликнулся пользователь
        return vacancyDao.getVacancyByResponds(authorEmail);
    }

    public List<Vacancy> getAllVacancy() {
        // Выборка всех вакансий
        return vacancyDao.getAllVacancy();
    }

    public List<Vacancy> getVacancyByCategory(Long categoryId) {
        // Выборка вакансий по категориям
        return vacancyDao.getVacancyByCategory(categoryId);
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

    public void deleteVacancy(Long vacancyId){
        vacancyDao.deleteVacancy(vacancyId);
    }
}
