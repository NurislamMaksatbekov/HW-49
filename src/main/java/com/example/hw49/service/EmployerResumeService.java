package com.example.hw49.service;

import com.example.hw49.dao.EmployerResumeDao;
import com.example.hw49.entity.EmployerResume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerResumeService {
    private final EmployerResumeDao employerResumeDao;


}
