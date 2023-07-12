package com.example.hw49.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WhoResponded {
    private Long id;
    private String whoResponded;
    private Long forWhatResponded;
    private LocalDateTime dateTime;
}
