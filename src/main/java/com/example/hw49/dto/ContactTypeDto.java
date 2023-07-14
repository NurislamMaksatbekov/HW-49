package com.example.hw49.dto;

import com.example.hw49.enums.ContactType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactTypeDto {
    private ContactType contactType;
}
