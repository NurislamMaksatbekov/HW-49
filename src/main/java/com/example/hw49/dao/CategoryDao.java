package com.example.hw49.dao;

import com.example.hw49.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryDao{

    private final JdbcTemplate jdbcTemplate;

    public String getTitleById(Long id) {
        String sql = "select  TITLE from CATEGORIES where id = ?";
        return DataAccessUtils.singleResult(Collections.singleton(jdbcTemplate.queryForObject(sql, String.class, id)));
    }

    public Optional<Category> getIdByTitle(String title) {
        String sql = "select * from categories where title = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class), title)
        ));
    }
}
