package com.example.hw49.dao;

import com.example.hw49.entity.Contact;
import com.example.hw49.enums.ContactType;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Optional;

@Component
public class ContactDao extends BaseDao {
    ContactDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public Long save(Object obj) {
        jdbcTemplate.update(con -> {
            Contact c = (Contact) obj;
            PreparedStatement ps = con.prepareStatement(
                    "insert into contacts(value, contact_type, resume_id) " +
                            "values (?,?,?)", new String[]{"id"});
            ps.setString(1, c.getValue());
            ps.setString(2, c.getContactType());
            ps.setLong(3, c.getResumeId());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public String getType(String type){
        String sql = "select type from CONTACTS_TYPE where type = ?";
             return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(String.class), type);
    }

    @Override
    public void delete(Long id) {

    }
}
