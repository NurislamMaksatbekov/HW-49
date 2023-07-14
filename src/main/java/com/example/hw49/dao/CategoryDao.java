package com.example.hw49.dao;

import com.example.hw49.entity.Category;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryDao {
    private final JdbcTemplate jdbcTemplate;

    @SneakyThrows
    public Category getCategoryById(Long id){
        String sql = "select * from categories where title = ?";

        Optional<Category> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class), id)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("Category not found");
        }

        return mayBeUser.get();
    }

}
