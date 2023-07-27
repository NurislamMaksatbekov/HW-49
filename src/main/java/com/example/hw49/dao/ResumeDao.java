package com.example.hw49.dao;


import com.example.hw49.entity.Resume;
import lombok.SneakyThrows;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ResumeDao extends BaseDao {

    ResumeDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate1) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }


    public List<Resume> findResumeByCategory(Long categoryId) {
        String sql = "select * from " +
                "resumes where " +
                "category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), categoryId);
    }

    public List<Resume> findResumeByTitle(String title) {
        String sql = "select * from " +
                "resumes where title = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), title);
    }

    public List<Resume> selectResumesByUser(String authorEmail) {
        String sql = "select * from" +
                " resumes where" +
                " author_email = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), authorEmail);
    }

    @SneakyThrows
    public Resume findResumeById(Long resumeId) {
        String sql = "select * from" +
                " resumes where id = ?";
        Optional<Resume> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), resumeId)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("Category not found");
        }
        return mayBeUser.get();
    }

    public List<Resume> findAllResumes() {
        String sql = "select * from resumes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class));
    }

    @Override
    public Long save(Object obj) {
        jdbcTemplate.update(con -> {
            Resume r = (Resume) obj;
            PreparedStatement ps = con.prepareStatement(
                    "insert into resumes(TITLE, CATEGORY_ID, REQUIRED_SALARY, AUTHOR_EMAIL, ACTIVE, DATE_OF_POSTED) " +
                            "values (?, ?, ?, ?, ?, ?)",
                    new String[]{"id"});
            ps.setString(1, r.getTitle().toUpperCase());
            ps.setLong(2, r.getCategoryId());
            ps.setDouble(3, r.getRequiredSalary());
            ps.setString(4, r.getAuthorEmail());
            ps.setBoolean(5, r.isActive());
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

//    public Long change(Object obj) {
////        Resume r = (Resume) obj;
////        String sql = "UPDATE RESUMES " +
////                "SET TITLE = ?, REQUIRED_SALARY = ?, " +
////                "    AUTHOR_EMAIL = ?,  ACTIVE = ? " +
////                "WHERE ID = ?";
////
////        jdbcTemplate.update(con -> {
////            PreparedStatement ps = con.prepareStatement(sql);
////            ps.setString(1, r.getTitle());
////            ps.setDouble(2, r.getRequiredSalary());
////            ps.setString(3, r.getAuthorEmail());
////            ps.setBoolean(4, r.isActive());
////            ps.setLong(5, r.getId());
////            return ps;
////        }, keyHolder);
//        return Objects.requireNonNull(keyHolder.getKey()).longValue();
//    }

    public void change(Resume r){
        String sql = "UPDATE RESUMES " +
                "SET TITLE = ?, REQUIRED_SALARY = ?, " +
                "    AUTHOR_EMAIL = ?,  ACTIVE = ?, DATE_OF_UPDATED = ?, CATEGORY_ID = ?" +
                "WHERE ID = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, r.getTitle());
            ps.setDouble(2, r.getRequiredSalary());
            ps.setString(3, r.getAuthorEmail());
            ps.setBoolean(4, r.isActive());
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            ps.setLong(6, r.getCategoryId());
            ps.setLong(7, r.getId());
            return ps;
        }, keyHolder);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM RESUMES WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
