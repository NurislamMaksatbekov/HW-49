package com.example.hw49.dao;

import com.example.hw49.entity.Experience;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Component

public class ExperienceDao extends BaseDao{

    ExperienceDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    public List<Experience> getExperienceByResumeId(Long id){
        String sql = "select * from experiences where resume_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Experience.class), id);
    }

    @Override
    public Long save(Object obj) {
        Experience e = (Experience) obj;
        String sql = "insert into experiences(company_name, work_period, RESPONSIBILITIES, resume_id) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, e.getCompanyName());
            ps.setString(2, e.getWorkPeriod());
            ps.setString(3, e.getResponsibilities());
            ps.setLong(4, e.getResumeId());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void change(Object obj) {
    Experience e = (Experience) obj;
    String sql = "update experiences set(company_name = ?, work_period = ?, RESPONSIBILITIES = ? where id = ?)";
    jdbcTemplate.update(con -> {
        PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
        ps.setString(1, e.getCompanyName());
        ps.setString(2, e.getWorkPeriod());
        ps.setString(3, e.getResponsibilities());
        ps.setLong(4, e.getId());
        return ps;
    }, keyHolder);
    }

    @Override
    public void delete(Long id) {

    }
}
