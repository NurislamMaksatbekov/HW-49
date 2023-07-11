package com.example.hw49.service;

import com.example.hw49.dao.ResumeDao;
import com.example.hw49.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeDao resumeDao;

    public List<Resume> findResumeByCategory(Long id){
        return resumeDao.findResumeByCategory(id);
    }

    public List<Resume> selectResumeByUser(String authorEmail){
        return resumeDao.selectResumesByUser(authorEmail);
    }
}
