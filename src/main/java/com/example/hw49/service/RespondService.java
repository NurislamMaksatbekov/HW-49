package com.example.hw49.service;

import com.example.hw49.dao.RespondDao;
import com.example.hw49.dto.RespondDto;
import com.example.hw49.entity.WhoResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RespondService {
    private final RespondDao respondDao;
    private final VacancyService vacancyService;

    public void respondVacancy(RespondDto respondDto, Authentication auth) {
        User u = (User) auth.getPrincipal();
        respondDao.respond(WhoResponded.builder()
                .responderEmail(u.getUsername())
                .respondedVacancyId(respondDto.getRespondedVacancyId())
                .build());
    }
}
