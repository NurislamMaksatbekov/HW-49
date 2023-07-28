package com.example.hw49.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDto {
    @NotBlank(message = "Контактные данные не могут быть пустыми")
    private String contactValue;
    @NotBlank(message = "Контактные данные не могут быть пустыми")
    private String contactType;
}
