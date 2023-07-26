package com.example.hw49.dao;

import com.example.hw49.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
//    private final PasswordEncoder encoder;

    public Optional<User> findUserByName(String name) {
        String sql = "select * from users where name = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), name)
        ));
    }

    public Optional<User> findUserByPhoneNumber(String number) {
        String sql = "select * from users where phone_number = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), number)
        ));
    }

    @SneakyThrows
    public String findUserEmail(Long id) {
        String sql = "select AUTHOR_EMAIL from RESUMES " +
                "where id = ?";
        Optional<String> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(String.class), id)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("User not found");
        }

        return mayBeUser.get();
    }

    public boolean checkUser(String email) {
        String sql = "select case when exists(" +
                "select * from users where email = ?) " +
                "then true " +
                "else false " +
                "end ";
        return jdbcTemplate.queryForObject(sql, Boolean.class, email);
    }

    public List<User> getUserByResponds(Long vacancyId) {
        String sql = "select * from users u " +
                "inner join responds r on u.email = r.RESPONDER_EMAIL " +
                "where RESPONDED_VACANCY_ID = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), vacancyId);
    }

    @SneakyThrows
    public User findApplicant(String email) {
        String sql = "select * from USERS u\n" +
                "where ACCOUNT_TYPE = 'Applicant'\n" +
                "and EMAIL = ?";
        Optional<User> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("User not found");
        }

        return mayBeUser.get();
    }

    @SneakyThrows
    public User findEmployer(String email) {
        String sql = "select * from USERS u\n" +
                "where ACCOUNT_TYPE = 'Employer'\n" +
                "and EMAIL = ?";
        Optional<User> mayBeUser = Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));

        if (mayBeUser.isEmpty()) {
            throw new Exception("User not found");
        }

        return mayBeUser.get();
    }

    public void addNewUser(User user){
        String sql = "insert into users(EMAIL, NAME, SURNAME, USERNAME, PASSWORD, PHOTO, PHONE_NUMBER, ACCOUNT_TYPE, ENABLED) " +
                "values (?, ?, ?, ?, ?, ?, ?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail().toLowerCase());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getUsername());
//            ps.setString(5, encoder.encode(user.getPassword()));
            ps.setString(6, user.getPhoto());
            ps.setString(7, user.getPhoneNumber());
            ps.setString(8, user.getAccountType().toUpperCase());
            ps.setBoolean(9,true);
            return ps;
        });
    }
}
