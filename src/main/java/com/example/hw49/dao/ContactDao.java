package com.example.hw49.dao;

import com.example.hw49.entity.Contact;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Objects;

@Component
public class ContactDao extends BaseDao{

    ContactDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public Long save(Object obj) {
        jdbcTemplate.update(con -> {
            Contact c = (Contact) obj;
            PreparedStatement ps = con.prepareStatement(
                    "insert into CONTACTS(CONTACT_VALUE, CONTACT_TYPE, RESUME_ID)" +
                            "values (?,?,?)", new String[]{"id"}
            );
            ps.setString(1, c.getContactValue());
            ps.setString(2, c.getContactType());
            ps.setLong(3, c.getResumeId());
            return ps;
        },keyHolder);
    return (Objects.requireNonNull(keyHolder.getKey())).longValue();
    }

    public void change(Contact contact){
        String sql = "update contacts set contact_value = ?, contact_type = ? where resume_id = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, contact.getContactValue());
            ps.setString(2, contact.getContactType());
            ps.setLong(3, contact.getResumeId());
            return ps;
        }, keyHolder);
    }

    public Contact getContactsByResumeId(Long id){
        String sql = "select * from contacts where resume_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Contact.class), id);
    }

    @Override
    public void delete(Long id) {

    }
}
