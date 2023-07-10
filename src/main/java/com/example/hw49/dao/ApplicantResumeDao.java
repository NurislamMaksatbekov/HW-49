package com.example.hw49.dao;


import com.example.hw49.entity.ApplicantResume;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicantResumeDao {
    private final JdbcTemplate jdbcTemplate;

    public List<ApplicantResume> findResumeByCategory(Long categoryId){
        String sql = "select * from " +
                "applicants_resume where " +
                "category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ApplicantResume.class), categoryId);
    }

    public List<ApplicantResume> selectResumesByUser(Long userId){
        String sql = "select * from" +
                " applicants_resume where" +
                " user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ApplicantResume.class), userId);
    }
}
