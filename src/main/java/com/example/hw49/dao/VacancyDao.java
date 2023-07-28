package com.example.hw49.dao;

import com.example.hw49.entity.Vacancy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Component

public class VacancyDao extends BaseDao{

    VacancyDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    public List<Vacancy> getVacancyByResponds(String authorEmail){
        String sql = "select * from vacancies as v " +
                "inner join responds as r on v.id = r.for_what_responded " +
                "where r.respond = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), authorEmail);
    }

    public List<Vacancy> getAllVacancy(){
        String sql = "select * from vacancies";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public List<Vacancy> getVacancyByCategory(Long categoryId){
        String sql = "select * from vacancies " +
                "where category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), categoryId);
    }

    public List<Vacancy> myVacancies(String email){
        String sql = "select * from vacancies where author_email = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), email);
    }


    @Override
    public Long save(Object obj) {
        jdbcTemplate.update(con -> {
            Vacancy v = (Vacancy) obj;
            PreparedStatement ps = con.prepareStatement(
                    "insert into vacancies(title, salary, author_email, job_description, REQUIRED_MIN_EXPERIENCE, REQUIRED_MAX_EXPERIENCE, DATE_OF_POSTED,  active, CATEGORY_ID) " +
                            "values (?,?,?,?,?,?,?,?,?)",
                    new String[]{"id"}
            );
            ps.setString(1, v.getTitle());
            ps.setDouble(2, v.getSalary());
            ps.setString(3, v.getAuthorEmail());
            ps.setString(4, v.getJobDescription());
            ps.setInt(5, v.getRequiredMinExperience());
            ps.setInt(6, v.getRequiredMaxExperience());
            ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            ps.setBoolean(8, v.isActive());
            ps.setLong(9, v.getCategoryId());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public void change(Object obj) {
        Vacancy v = (Vacancy) obj;
        String sql = "UPDATE vacancies " +
                "SET title = ?, salary = ?, job_description = ?, " +
                "    REQUIRED_MIN_EXPERIENCE = ?, REQUIRED_MAX_EXPERIENCE = ?,  " +
                "    DATE_OF_UPDATED = ?, active = ?, CATEGORY_ID = ? " +
                "WHERE ID = ? and " +
                "AUTHOR_EMAIL = ?";

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, v.getTitle());
            ps.setDouble(2, v.getSalary());
            ps.setString(3, v.getJobDescription());
            ps.setInt(4, v.getRequiredMinExperience());
            ps.setInt(5, v.getRequiredMaxExperience());
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            ps.setBoolean(7, v.isActive());
            ps.setLong(8, v.getCategoryId());
            ps.setLong(9, v.getId());
            ps.setString(10, v.getAuthorEmail());

            return ps;
        }, keyHolder );
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM vacancies WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    public boolean check(Long id, String email){
        String sql = "select case when exists(select * from vacancies where id = ? and AUTHOR_EMAIL = ?)\n" +
                "then true\n" +
                "else false end;";
        return jdbcTemplate.queryForObject(sql, Boolean.class, id, email);
    }

    public boolean checkVacancy(Long id){
        String sql = "select case when exists(select * from vacancies where id = ?) " +
                "then true " +
                "else false end";
        return jdbcTemplate.queryForObject(sql, Boolean.class, id);
    }
}
