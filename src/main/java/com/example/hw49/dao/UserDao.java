package com.example.hw49.dao;

import com.example.hw49.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public boolean checkUser(String email){
        String sql = "select case when exists(" +
                "select * from users where email = ?) " +
                "then true " +
                "else false " +
                "end ";
        return jdbcTemplate.queryForObject(sql, Boolean.class, email);
    }

    public List<User> getUserByResponds(Long vacancyId){
        String sql = "select * from USERS\n" +
                "inner join VACANCY V on USERS.ID = V.AUTHOR_ID\n" +
                "inner join RESPONDS R on V.ID = R.FOR_WHAT_RESPONDED\n" +
                "where r.FOR_WHAT_RESPONDED = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), vacancyId);
    }
}
