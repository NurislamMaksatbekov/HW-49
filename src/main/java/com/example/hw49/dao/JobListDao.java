package com.example.hw49.dao;


import com.example.hw49.entity.JobList;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JobListDao {
    private final JdbcTemplate jdbcTemplate;

    public List<JobList> selectVacancyByEmployer(Long authorId){
        String sql = "select * from " +
                "job_lists where " +
                "applicant_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JobList.class), authorId);
    }

    public List<JobList> selectAllVacancy(){
        String sql = "select * from " +
                "job_lists";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JobList.class));
    }
}
