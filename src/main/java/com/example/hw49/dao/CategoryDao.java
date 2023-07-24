package com.example.hw49.dao;

import com.example.hw49.entity.Category;
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
public class CategoryDao {
    private final JdbcTemplate jdbcTemplate;

    @SneakyThrows
    public String getCategoryById(Long id) {
        String sql = "select title from categories where id = ?";

        Optional<String> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(String.class), id)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("Category not found");
        }

        return mayBeUser.get();
    }


}
