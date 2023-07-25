package com.example.hw49.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Experience {
    private Long id;
    private String companyName;
    private String workPeriod;
    private String responsibilities;
    private Long resumeId;
}
