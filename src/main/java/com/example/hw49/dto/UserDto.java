package com.example.hw49.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {
    private String name;
    private String surname;
    private String username;
    @Email(message = "Введите правильные данные для email")
    @NotBlank(message = "email не может быть пустым")
    private String email;
    @Size(min = 7, max = 30, message = "Пароль должен состоять от 7 до 30 символов")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
    private MultipartFile photo;
    private String phoneNumber;
    @NotBlank(message = "Тип аккаунта не может быть пустым")
    private String accountType;
}
