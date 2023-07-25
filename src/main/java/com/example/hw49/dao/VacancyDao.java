package com.example.hw49.dao;

import com.example.hw49.entity.Vacancy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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



    public void changeVacancy(Vacancy vacancy) {

    }

    public void deleteVacancy(Long vacancyId) {
        String sql = "DELETE FROM vacancies WHERE ID = ?";

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vacancyId);
            return ps;
        });
    }


    @Override
    public Long save(Object obj) {
        jdbcTemplate.update(con -> {
            Vacancy v = (Vacancy) obj;
            PreparedStatement ps = con.prepareStatement(
                    "insert into vacancies(title, salary, author_email, job_description, REQUIRED_MIN_EXPERIENCE, REQUIRED_MAX_EXPERIENCE, DATE_OF_POSTED, DATE_OF_UPDATED, active, CATEGORY_ID) " +
                            "values (?,?,?,?,?,?,?,?,?,?)",
                    new String[]{"id"}
            );
            daoSql(v, ps);
            ps.setLong(10, v.getCategoryId());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void change(Object obj) {
        Vacancy v = (Vacancy) obj;
        String sql = "UPDATE vacancies " +
                "SET title = ?, salary = ?, author_email = ?, job_description = ?, " +
                "    REQUIRED_MIN_EXPERIENCE = ?, REQUIRED_MAX_EXPERIENCE = ?, DATE_OF_POSTED = ?, " +
                "    DATE_OF_UPDATED = ?, active = ? " +
                "WHERE ID = ?";

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            daoSql(v, ps);
            ps.setLong(10, v.getId());

            return ps;
        });
    }

    private void daoSql(Vacancy v, PreparedStatement ps) throws SQLException {
        ps.setString(1, v.getTitle());
        ps.setDouble(2, v.getSalary());
        ps.setString(3, v.getAuthorEmail());
        ps.setString(4, v.getJobDescription());
        ps.setInt(5, v.getRequiredMinExperience());
        ps.setInt(6, v.getRequiredMaxExperience());
        ps.setDate(7, Date.valueOf(v.getDateOfPosted()));
        ps.setDate(8, Date.valueOf(v.getDateOfUpdated()));
        ps.setBoolean(9, v.isActive());
    }

    @Override
    public void delete(Long id) {

    }
}
