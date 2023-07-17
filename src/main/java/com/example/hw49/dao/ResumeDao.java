package com.example.hw49.dao;


import com.example.hw49.dto.ResumeDto;
import com.example.hw49.entity.Category;
import com.example.hw49.entity.Resume;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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

    public void createNewResume(Resume resume){
        String sql = "insert into resumes(TITLE, CATEGORY_ID, REQUIRED_SALARY, AUTHOR_EMAIL, EXPERIENCE_ID, EDUCATION_ID, ACTIVE) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, resume.getTitle());
            ps.setLong(2, resume.getCategoryId());
            ps.setDouble(3, resume.getRequiredSalary());
            ps.setString(4, resume.getAuthorEmail());
            ps.setLong(5, resume.getExperienceId());
            ps.setLong(6, resume.getEducationId());
            ps.setBoolean(7, resume.isActive());
            return ps;
        });
    }


}
