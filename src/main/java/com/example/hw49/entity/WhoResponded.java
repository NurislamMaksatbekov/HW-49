package com.example.hw49.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WhoResponded {
    private Long id;
    private Employee whoResponded;
    private JobList forWhatResponded;
    private LocalDateTime dateTime;
}
