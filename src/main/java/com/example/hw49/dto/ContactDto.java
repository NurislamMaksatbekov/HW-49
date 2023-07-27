package com.example.hw49.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDto {
    private Long id;
    private String value;
    private String contactType;
}
