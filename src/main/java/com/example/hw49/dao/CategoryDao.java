package com.example.hw49.dao;

import com.example.hw49.entity.Category;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class CategoryDao extends BaseDao {

    CategoryDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

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

    public List<Category> getAllCategories() {
        String sql = "select * from categories";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }


    @Override
    public Long save(Object obj) {
        String sql = "insert into categories(title)" +
                "values (?)";
        jdbcTemplate.update(con -> {
            Category c = (Category) obj;
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, c.getTitle().toUpperCase());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void delete(Long id) {
    }


}
