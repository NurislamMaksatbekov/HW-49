package com.example.hw49.dao;

import com.example.hw49.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public Optional<User> findUserByName(String name){
        String sql = "select * from users where name = ?";
    return Optional.ofNullable(DataAccessUtils.singleResult(
            jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), name)
    ));
    }

    public Optional<User> findUserByPhoneNumber(String number){
        String sql = "select * from users where number = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), number)
        ));
    }

    public Optional<User> findUserByEmail(String email){
        String sql = "select * from users where email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));
    }
}
