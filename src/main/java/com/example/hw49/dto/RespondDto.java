package com.example.hw49.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RespondDto {
    private Long id;
    private LocalDateTime timeOfRespond;
    private String responderEmail;
    private Long respondedVacancyId;
}
