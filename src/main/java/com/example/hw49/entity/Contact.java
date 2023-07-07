package com.example.hw49.entity;

import lombok.Data;

@Data
public class Contact {
    private Long id;
    private String telegram;
    private String email;
    private String number;
    private String facebookLink;
    private String linkedinLink;
}
