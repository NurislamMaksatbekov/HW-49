package com.example.hw49.service;

import com.example.hw49.dao.VacancyDao;
import com.example.hw49.dto.VacancyDto;
import com.example.hw49.entity.Vacancy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VacancyService {
    private final VacancyDao vacancyDao;
    private final CategoryService categoryService;
    private List<VacancyDto> vacancyDtoList(List<Vacancy> vacancies) {
        return vacancies.stream().map(e -> VacancyDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .salary(e.getSalary())
                .authorEmail(e.getAuthorEmail())
                .jobDescription(e.getJobDescription())
                .requiredMinExperience(e.getRequiredMinExperience())
                .requiredMaxExperience(e.getRequiredMaxExperience())
                .dateOfPosted(e.getDateOfPosted())
                .dateOfUpdated(e.getDateOfUpdated())
                .active(e.isActive())
                .category(categoryService.getTitleById(e.getCategoryId()))
                .build()).toList();
    }

    public List<VacancyDto> getVacancyByCategory(Long categoryId) {
        List<Vacancy> vacancies = vacancyDao.getVacancyByCategory(categoryId);
        log.info(categoryId.toString());
        return vacancyDtoList(vacancies);
    }

    public void deleteVacancy(Long vacancyId) {
        log.info("Вакансия удалена");
        vacancyDao.deleteVacancy(vacancyId);
    }

    public List<VacancyDto> findAllVacancies() {
        List<Vacancy> vacancies = vacancyDao.getAllVacancy();
        return vacancyDtoList(vacancies);
    }

    public void saveVacancy(VacancyDto vacancyDto) {
        var mayBeCategory = categoryService.getIdByTitle(vacancyDto.getCategory().toUpperCase());
        Long categoryId;
        if (mayBeCategory.isEmpty()) {
            log.error("Выберите категорию работы!");
        } else {
            categoryId = mayBeCategory.get().getId();
            vacancyDao.save(Vacancy.builder()
                    .title(vacancyDto.getTitle())
                    .salary(vacancyDto.getSalary())
                    .authorEmail(vacancyDto.getAuthorEmail())
                    .jobDescription(vacancyDto.getJobDescription())
                    .requiredMinExperience(vacancyDto.getRequiredMinExperience())
                    .requiredMaxExperience(vacancyDto.getRequiredMaxExperience())
                    .active(vacancyDto.isActive())
                    .categoryId(categoryId)
                    .build());
            log.info("Вакансия сохранена");
        }
    }


    public void change(VacancyDto vacancyDto) {
        vacancyDao.change(Vacancy.builder()
                .title(vacancyDto.getTitle())
                .salary(vacancyDto.getSalary())
                .authorEmail(vacancyDto.getAuthorEmail())
                .jobDescription(vacancyDto.getJobDescription())
                .requiredMinExperience(vacancyDto.getRequiredMinExperience())
                .requiredMaxExperience(vacancyDto.getRequiredMaxExperience())
                .dateOfPosted(vacancyDto.getDateOfPosted())
                .dateOfUpdated(vacancyDto.getDateOfUpdated())
                .active(vacancyDto.isActive())
                .id(vacancyDto.getId())
                .build());
        log.info("Вакансия изменена");
    }
}
