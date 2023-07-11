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
        // Поиск резюме по категории
        return resumeDao.findResumeByCategory(id);
    }

    public List<Resume> selectResumeByUser(String authorEmail){
        // Выборка созданных пользователем резюме
        return resumeDao.selectResumesByUser(authorEmail);
    }
}
