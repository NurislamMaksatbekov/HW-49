package com.example.hw49.entity;

import lombok.Data;

@Data
public class Contact {
    private int id;
    private String value;
    private String contactType;
    private Long resumeId;

}
