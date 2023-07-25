package com.example.hw49.dao;

import com.example.hw49.entity.Education;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Component

public class EducationDao extends BaseDao{

    EducationDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    public List<Education> getEducationById(Long id){
        String sql = "select * from educations where resume_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Education.class), id);
    }

    @Override
    public Long save(Object obj) {
        Education e = (Education) obj;
        String sql = "insert into educations(education, place_of_study, study_period, resume_id) " +
                "values (?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, e.getEducation());
            ps.setString(2, e.getPlaceOfStudy());
            ps.setString(3, e.getStudyPeriod());
            ps.setLong(4, e.getResumeId());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void change(Object obj) {
    Education e = (Education) obj;
    String sql = "update educations set(education = ?, place_of_study = ?, study_period = ? where id = ?)";
    jdbcTemplate.update(con -> {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, e.getEducation());
        ps.setString(2, e.getPlaceOfStudy());
        ps.setString(3, e.getStudyPeriod());
        ps.setLong(4, e.getId());
        return ps;
    }, keyHolder);
    }

    @Override
    public void delete(Long id) {

    }
}
