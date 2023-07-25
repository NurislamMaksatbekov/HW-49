package com.example.hw49.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Education {
    private Long id;
    private String education;
    private String placeOfStudy;
    private String studyPeriod;
    private Long resumeId;
}
