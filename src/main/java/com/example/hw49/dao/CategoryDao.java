package com.example.hw49.dao;

import com.example.hw49.entity.Category;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryDao {
    private final JdbcTemplate jdbcTemplate;

    public String getTitleById(Long id){
        String sql = "select  TITLE from CATEGORIES where id = ?";
        return DataAccessUtils.singleResult(Collections.singleton(jdbcTemplate.queryForObject(sql, String.class, id)));
    }


}
