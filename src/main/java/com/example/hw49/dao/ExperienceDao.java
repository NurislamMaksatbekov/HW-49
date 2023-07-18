package com.example.hw49.dao;

import com.example.hw49.entity.Education;
import com.example.hw49.entity.Experience;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExperienceDao {
    private final JdbcTemplate jdbcTemplate;

    @SneakyThrows
    public Experience getExperienceById(Long id){
        String sql = "select * from experiences where id = ?";
        Optional<Experience> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Experience.class), id)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("Experience not found");
        }

        return mayBeUser.get();
    }
}
