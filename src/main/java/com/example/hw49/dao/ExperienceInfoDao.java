package com.example.hw49.dao;

import com.example.hw49.dto.ExperienceInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExperienceInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<ExperienceInfoDto> getExperienceByAuthor(String email) {
        String sql = ("SELECT E.COMPANY_NAME\n" +
                "FROM EXPERIENCES_INFO EI\n" +
                "JOIN EXPERIENCES E ON EI.EXPERIENCE_ID = E.ID\n" +
                "JOIN RESUMES R ON R.EXPERIENCE_INFO_ID = EI.ID\n" +
                "WHERE R.AUTHOR_EMAIL = ?");
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ExperienceInfoDto.class), email);
    }
}
