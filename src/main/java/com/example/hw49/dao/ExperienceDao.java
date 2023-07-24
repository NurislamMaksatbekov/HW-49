package com.example.hw49.dao;

import com.example.hw49.dto.ExperienceDto;
import com.example.hw49.entity.Education;
import com.example.hw49.entity.Experience;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j

public class ExperienceDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Experience> getExperienceByResumeId(Long id){
        String sql = "select * from experiences where resume_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Experience.class), id);
    }
}
