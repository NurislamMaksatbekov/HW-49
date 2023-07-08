package com.example.hw49.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WhoResponded {
    private Long id;
    private EmployeeResume whoResponded;
    private JobList forWhatResponded;
    private LocalDateTime dateTime;
}
