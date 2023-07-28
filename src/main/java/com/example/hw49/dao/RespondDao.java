package com.example.hw49.dao;

import com.example.hw49.entity.WhoResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor

public class RespondDao {
    private final JdbcTemplate jdbcTemplate;

    public void respond(WhoResponded respond){
        String sql = "insert into responds(time_of_responds, responder_email, responded_vacancy_id) " +
                "values(?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(2, respond.getResponderEmail());
            ps.setLong(3, respond.getRespondedVacancyId());
            return ps;
        });

    }
}
