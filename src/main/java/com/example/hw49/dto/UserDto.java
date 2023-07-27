package com.example.hw49.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
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
    @Email
    private String email;
    @Size(min = 7)
    private String password;
    private MultipartFile photo;
    private String phoneNumber;
    private String accountType;
}
