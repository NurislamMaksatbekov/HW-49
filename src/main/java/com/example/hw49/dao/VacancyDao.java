package com.example.hw49.dao;

import com.example.hw49.entity.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Vacancy> getVacancyByResponds(String authorEmail){
        String sql = "select * from vacancy as v " +
                "inner join responds as r on v.id = r.for_what_responded " +
                "where r.respond = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), authorEmail);
    }

    public List<Vacancy> getAllVacancy(){
        String sql = "select * from vacancy";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public List<Vacancy> getVacancyByCategory(Long categoryId){
        String sql = "select * from vacancy " +
                "where category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), categoryId);
    }
}
