package com.example.hw49.dao;

import com.example.hw49.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
        String sql = "select * from users where phone_number = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), number)
        ));
    }
    @SneakyThrows
    public User findUserByEmail(String email){
        String sql = "select * from users where email = ?";
        Optional<User> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("User not found");
        }

        return mayBeUser.get();
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
        String sql = "select * from users u " +
                "inner join responds r on u.email = r.RESPONDER_EMAIL " +
                "where RESPONDED_VACANCY_ID = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), vacancyId);
    }
}
