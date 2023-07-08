package com.crud_simple.traine_crud.dao;

import com.crud_simple.traine_crud.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PhoneDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Phone phone) {
        jdbcTemplate.update("INSERT INTO Phone values(?, ?, ?)",
                phone.getName(), phone.getAnnouncedDate(), phone.getPrice());
    }

    public void update(int id, Phone phone) {
        jdbcTemplate.update("UPDATE Person SET name=?, announcedDate=?, price=? WHERE id=?",
                phone.getName(), phone.getAnnouncedDate(), phone.getPrice(), id);
    }

    public Phone findEntityById(int id) {
        return jdbcTemplate.query("SELECT * FROM Phone WHERE id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Phone.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public List<Phone> findAll() {
        return jdbcTemplate.query("SELECT * FROM Phone", new BeanPropertyRowMapper<>(Phone.class));
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Phone WHERE id=?", id);
    }
}
