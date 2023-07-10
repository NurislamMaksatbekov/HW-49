package com.example.hw49.dao;

import com.example.hw49.entity.EmployerResume;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployerResumeDao {
    private JdbcTemplate jdbcTemplate;

    public List<EmployerResume> findEmployerResumeByCategory(Long categoryId){
        String sql = "select * from " +
                "employers_resume where " +
                "category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EmployerResume.class), categoryId);
    }
}
