package com.example.hw49.dao;

import com.example.hw49.entity.Education;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j

public class EducationDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Education> getEducationById(Long id){
        String sql = "select * from educations where resume_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Education.class), id);
    }

    public void createNewEducation(Education education){
        String sql = "insert into educations(education, place_of_study, study_period, resume_id) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, education.getEducation());
            ps.setString(2, education.getPlaceOfStudy());
            ps.setString(3, education.getStudyPeriod());
            ps.setLong(4, education.getResumeId());
            return ps;
        });
    }
}
