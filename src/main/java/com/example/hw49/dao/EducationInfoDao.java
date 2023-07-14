package com.example.hw49.dao;

import com.example.hw49.dto.EducationInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EducationInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<EducationInfoDto> getEducationByAuthor(String email) {
        String sql = ("SELECT E.EDUCATION\n" +
                "FROM EDUCATIONS_INFO EI\n" +
                "JOIN EDUCATIONS E ON EI.EDUCATION_ID = E.ID\n" +
                "JOIN RESUMES R ON R.EDUCATION_INFO_ID = EI.ID\n" +
                "WHERE R.AUTHOR_EMAIL = ?");
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EducationInfoDto.class), email);
    }
}
