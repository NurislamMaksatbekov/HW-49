package com.example.hw49.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String photo;
    private String phoneNumber;
    private String accountType;
}
