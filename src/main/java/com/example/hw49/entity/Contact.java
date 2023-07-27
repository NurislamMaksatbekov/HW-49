package com.example.hw49.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Contact {
    private int id;
    private String value;
    private String contactType;
    private Long resumeId;

}
