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
       return vacancyDao.getVacancyByResponds(authorEmail);
    }

    public List<Vacancy> getAllVacancy(){
        return vacancyDao.getAllVacancy();
    }

    public List<Vacancy> getVacancyByCategory(Long categoryId){
        return vacancyDao.getVacancyByCategory(categoryId);
    }

}
