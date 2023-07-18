package com.example.hw49.dao;

import com.example.hw49.entity.Education;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j

public class EducationDao {
    private final JdbcTemplate jdbcTemplate;

    @SneakyThrows
    public Education getEducationById(Long id){
        String sql = "select * from educations where id = ?";
        Optional<Education> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Education.class), id)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("Education not found");
        }

        return mayBeUser.get();
    }
}
