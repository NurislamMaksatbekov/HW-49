package com.example.hw49.controller;

import com.example.hw49.dto.RespondDto;
import com.example.hw49.service.RespondService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class RespondController {
    private final RespondService respondService;

    @PostMapping("respond")
    public void respond(@RequestBody RespondDto respondDto, Authentication auth) {
        respondService.respondVacancy(respondDto, auth);
    }
}
