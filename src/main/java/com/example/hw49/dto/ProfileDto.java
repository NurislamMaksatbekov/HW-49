package com.example.hw49.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfileDto {
    private String email;
    private String name;
    private String surname;
    private String photo;
    private String accountType;
    private List<ResumeDto> resumeDtoList;
}
