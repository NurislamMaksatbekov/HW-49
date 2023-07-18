package com.example.hw49.dao;

import com.example.hw49.entity.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
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

    public void createVacancy(Vacancy vacancy){
        String sql = "insert into vacancies(title, salary, author_email, job_description,  REQUIRED_MIN_EXPERIENCE, REQUIRED_MAX_EXPERIENCE, DATE_OF_POSTED, DATE_OF_UPDATED, active, CATEGORY_ID)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vacancy.getTitle());
            ps.setDouble(2, vacancy.getSalary());
            ps.setString(3, vacancy.getAuthorEmail());
            ps.setString(4, vacancy.getJobDescription());
            ps.setInt(5, vacancy.getRequiredMinExp());
            ps.setInt(6, vacancy.getRequiredMaxExp());
            ps.setDate(7, Date.valueOf(vacancy.getDateOfPosted()));
            ps.setDate(8, Date.valueOf(vacancy.getDateOfUpdated()));
            ps.setBoolean(9, vacancy.isActive());
            ps.setLong(10, vacancy.getCategoryId());

            return ps;
        });
    }

    public void changeVacancy(Vacancy vacancy) {
        String sql = "UPDATE vacancies " +
                "SET title = ?, salary = ?, author_email = ?, job_description = ?, " +
                "    REQUIRED_MIN_EXPERIENCE = ?, REQUIRED_MAX_EXPERIENCE = ?, DATE_OF_POSTED = ?, " +
                "    DATE_OF_UPDATED = ?, active = ?, CATEGORY_ID = ? " +
                "WHERE ID = ?";

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vacancy.getTitle());
            ps.setDouble(2, vacancy.getSalary());
            ps.setString(3, vacancy.getAuthorEmail());
            ps.setString(4, vacancy.getJobDescription());
            ps.setInt(5, vacancy.getRequiredMinExp());
            ps.setInt(6, vacancy.getRequiredMaxExp());
            ps.setDate(7, Date.valueOf(vacancy.getDateOfPosted()));
            ps.setDate(8, Date.valueOf(vacancy.getDateOfUpdated()));
            ps.setBoolean(9, vacancy.isActive());
            ps.setLong(10, vacancy.getCategoryId());
            ps.setLong(11, vacancy.getId());

            return ps;
        });
    }

    public void deleteVacancy(Long vacancyId) {
        String sql = "DELETE FROM vacancies WHERE ID = ?";

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vacancyId);
            return ps;
        });
    }


}
