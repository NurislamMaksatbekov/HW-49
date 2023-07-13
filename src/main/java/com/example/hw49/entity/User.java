package com.example.hw49.entity;

import lombok.Data;

@Data
public class User {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String photo;
    private String phoneNumber;
    private Long type;
}
