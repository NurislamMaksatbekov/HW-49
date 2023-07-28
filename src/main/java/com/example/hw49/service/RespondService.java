package com.example.hw49.service;

import com.example.hw49.dao.RespondDao;
import com.example.hw49.dto.RespondDto;
import com.example.hw49.entity.WhoResponded;
import com.example.hw49.errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RespondService {
    private final RespondDao respondDao;
    private final VacancyService vacancyService;

    public void respondVacancy(RespondDto respondDto, Authentication auth) {
        User u = (User) auth.getPrincipal();
        if (vacancyService.checkVacancy(respondDto.getRespondedVacancyId())) {
            respondDao.respond(WhoResponded.builder()
                    .responderEmail(u.getUsername())
                    .respondedVacancyId(respondDto.getRespondedVacancyId())
                    .build());
        } else throw new ResourceNotFoundException("Вы не можете откликнутся на вакансию под этим id, ибо она не существет");
    }
}
