package com.example.hw49.dao;


import com.example.hw49.dto.ResumeDto;
import com.example.hw49.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Resume> findResumeByCategory(Long categoryId){
        String sql = "select * from " +
                "resumes where " +
                "category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), categoryId);
    }

    public List<Resume> selectResumesByUser(String authorEmail){
        String sql = "select * from" +
                " resumes where" +
                " author_email = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), authorEmail);
    }

    public List<Resume> findResumesByAuthor(Long authorId){
        String sql = "select * from " +
                "resumes where " +
                "author_email = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), authorId);
    }

    public Optional<Resume> findResumeById(Long resumeId){
        String sql = "select * from" +
                " resumes where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), resumeId)
        ));
    }

    public void createNewResume(Resume resume){
        String sql = "insert into resumes(TITLE, REQUIRED_SALARY, ACTIVE, AUTHOR_EMAIL, EXPERIENCE_INFO_ID, EDUCATION_INFO_ID, CATEGORY_ID) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, resume.getTitle());
            ps.setDouble(2, resume.getRequiredSalary());
            ps.setBoolean(3, resume.isActive());
            ps.setString(4, resume.getAuthorEmail().toString());
            ps.setLong(5, resume.getExperienceInfoId());
            ps.setLong(6, resume.getEducationInfoId());
            ps.setLong(7, resume.getCategoryId());
            return ps;
        });
    }


}
