package com.example.hw49.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EducationDto {
    private Long id;
    @NotBlank(message = "Заполните поле")
    private String education;
    @NotBlank(message = "Заполните поле")
    private String placeOfStudy;
    @NotBlank(message = "Заполните поле")
    private String studyPeriod;
    private Long resumeId;
}
