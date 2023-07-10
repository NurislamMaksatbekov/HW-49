package com.example.hw49.service;

import com.example.hw49.dao.JobListDao;
import com.example.hw49.entity.JobList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobListService {
    private final JobListDao jobListDao;

    public List<JobList> selectVacancyByEmployer(Long authorId){
        return jobListDao.selectVacancyByEmployer(authorId);
    }
}
