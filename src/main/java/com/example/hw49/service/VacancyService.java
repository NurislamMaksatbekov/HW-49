package com.example.hw49.service;

import com.example.hw49.dao.VacancyDao;
import com.example.hw49.entity.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {
    private final VacancyDao vacancyDao;

    public List<Vacancy> getVacancyByResponds(String authorEmail){
        // Выборка вакансий на которые откликнулся пользователь
       return vacancyDao.getVacancyByResponds(authorEmail);
    }

    public List<Vacancy> getAllVacancy(){
        // Выборка всех вакансий
        return vacancyDao.getAllVacancy();
    }

    public List<Vacancy> getVacancyByCategory(Long categoryId){
        // Выборка вакансий по категориям
        return vacancyDao.getVacancyByCategory(categoryId);
    }

}
