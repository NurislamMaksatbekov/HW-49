package com.example.hw49.service;

import com.example.hw49.dao.VacancyDao;
import com.example.hw49.dto.VacancyDto;
import com.example.hw49.entity.Vacancy;
import com.example.hw49.errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
        if (vacancies.isEmpty()) {
            throw new ResourceNotFoundException("Not Found");
        }
        return vacancyDtoList(vacancies);
    }

    public void deleteVacancy(Long vacancyId, Authentication auth) {
        User u = (User) auth.getPrincipal();
        if (vacancyDao.check(vacancyId, u.getUsername())) {
            vacancyDao.delete(vacancyId);
            log.info("Вакансия удалена");
        } else log.error("У вас нет этой вакансии");
    }

    public List<VacancyDto> findAllVacancies() {
        List<Vacancy> vacancies = vacancyDao.getAllVacancy();
        return vacancies.stream().map(e -> VacancyDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .salary(e.getSalary())
                .dateOfUpdated(e.getDateOfUpdated())
                .dateOfPosted(e.getDateOfPosted())
                .build()).toList();
    }

    public List<VacancyDto> myVacancies(Authentication auth) {
        User u = (User) auth.getPrincipal();
        List<Vacancy> vacancies = vacancyDao.myVacancies(u.getUsername());
        return vacancies.stream().map(e -> VacancyDto.builder()
                .title(e.getTitle())
                .salary(e.getSalary())
                .jobDescription(e.getJobDescription())
                .requiredMinExperience(e.getRequiredMinExperience())
                .requiredMaxExperience(e.getRequiredMaxExperience())
                .dateOfPosted(e.getDateOfPosted())
                .dateOfUpdated(e.getDateOfUpdated())
                .active(e.isActive())
                .category(categoryService.getTitleById(e.getCategoryId()))
                .build()).toList();
    }

    public List<VacancyDto> lastVacancies(Authentication auth) {
        User u = (User) auth.getPrincipal();
        List<Vacancy> vacancies = vacancyDao.myVacancies(u.getUsername());
        return vacancies.stream().map(e -> VacancyDto.builder()
                        .title(e.getTitle())
                        .dateOfPosted(e.getDateOfPosted())
                        .dateOfUpdated(e.getDateOfUpdated())
                        .build())
                .toList();
    }

    public void saveVacancy(VacancyDto vacancyDto, Authentication auth) {
        User u = (User) auth.getPrincipal();
        var mayBeCategory = categoryService.getIdByTitle(vacancyDto.getCategory().toUpperCase());
        Long categoryId;
        if (mayBeCategory.isEmpty()) {
            log.error("Выберите категорию работы!");
        } else {
            categoryId = mayBeCategory.get().getId();
            vacancyDao.save(Vacancy.builder()
                    .title(vacancyDto.getTitle())
                    .salary(vacancyDto.getSalary())
                    .authorEmail(u.getUsername())
                    .jobDescription(vacancyDto.getJobDescription())
                    .requiredMinExperience(vacancyDto.getRequiredMinExperience())
                    .requiredMaxExperience(vacancyDto.getRequiredMaxExperience())
                    .active(vacancyDto.isActive())
                    .categoryId(categoryId)
                    .build());
            log.info(u.getUsername() + " добавил(а) вакансию");
        }
    }


    public void change(VacancyDto vacancyDto, Authentication auth) {
        User u = (User) auth.getPrincipal();

        if (vacancyDao.check(vacancyDto.getId(), u.getUsername())) {
            var categoryId = categoryService.getIdByTitle(vacancyDto.getCategory().toUpperCase());
            vacancyDao.change(Vacancy.builder()
                    .title(vacancyDto.getTitle())
                    .salary(vacancyDto.getSalary())
                    .authorEmail(u.getUsername())
                    .jobDescription(vacancyDto.getJobDescription())
                    .requiredMinExperience(vacancyDto.getRequiredMinExperience())
                    .requiredMaxExperience(vacancyDto.getRequiredMaxExperience())
                    .dateOfUpdated(vacancyDto.getDateOfUpdated())
                    .categoryId(categoryId.get().getId())
                    .active(vacancyDto.isActive())
                    .id(vacancyDto.getId())
                    .build());
            log.info("Вакансия изменена");
        } else log.error("У вас нет этой вакансии");
    }

    public boolean checkVacancy(Long id) {
        return vacancyDao.checkVacancy(id);
    }

    public VacancyDto getVacancy(Long id) {
        Vacancy vacancy = vacancyDao.getVacancy(id);
        return VacancyDto.builder()
                .id(vacancy.getId())
                .title(vacancy.getTitle())
                .salary(vacancy.getSalary())
                .authorEmail(vacancy.getAuthorEmail())
                .jobDescription(vacancy.getJobDescription())
                .requiredMinExperience(vacancy.getRequiredMinExperience())
                .requiredMaxExperience(vacancy.getRequiredMaxExperience())
                .dateOfPosted(vacancy.getDateOfPosted())
                .dateOfUpdated(vacancy.getDateOfUpdated())
                .active(vacancy.isActive())
                .category(categoryService.getTitleById(vacancy.getCategoryId()))
                .build();
    }
}
