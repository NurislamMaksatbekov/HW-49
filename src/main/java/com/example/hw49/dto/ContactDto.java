package com.example.hw49.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDto {
    private Long id;
    private String value;
    private String contactType;
}
