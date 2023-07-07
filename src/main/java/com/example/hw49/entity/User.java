package com.example.hw49.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private boolean type;
    private String password;
}
