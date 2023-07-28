package com.example.hw49.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExperienceDto {
    private Long id;
    @NotBlank(message = "Заполните поле")
    private String workPeriod;
    @NotBlank(message = "Заполните поле")
    private String responsibilities;
    @NotBlank(message = "Заполните поле")
    private String companyName;
    private Long resumeId;
}
