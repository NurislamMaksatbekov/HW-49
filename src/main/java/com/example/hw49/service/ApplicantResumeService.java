package com.example.hw49.service;

import com.example.hw49.dao.ApplicantResumeDao;
import com.example.hw49.entity.ApplicantResume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicantResumeService {
    private final ApplicantResumeDao applicantResumeDao;

    public List<ApplicantResume> findResumeByCategory(Long id){
        return applicantResumeDao.findResumeByCategory(id);
    }
}
