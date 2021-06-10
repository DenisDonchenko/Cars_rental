package com.car.rental.dao;

import com.car.rental.model.Tip_auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipAutoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TipAutoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tip_auto> index_tip(){
        return  jdbcTemplate.query("select * from tip_auto ;",
                new BeanPropertyRowMapper<>(Tip_auto.class));
    }

}
