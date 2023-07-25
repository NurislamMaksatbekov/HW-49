package com.example.hw49.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String photo;
    private String phoneNumber;
    private String accountType;
    private boolean enabled;
}
