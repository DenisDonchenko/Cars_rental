package com.car.rental.dao;
import com.car.rental.model.Auto;
import com.car.rental.model.Tip_auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Component
public class AutoDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AutoDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

    }


    public List<Tip_auto> index_tip(){
        return  jdbcTemplate.query("select * from tip_auto ;",
                new BeanPropertyRowMapper<>(Tip_auto.class));
    }
    public Auto show(int id){
        return  jdbcTemplate.query("select * from auto where id =? and auto.availability = 1",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Auto.class))
                .stream().findAny().orElse(null);
    }
    public  List <Auto> showTip(int id){
        return jdbcTemplate.query("select * from auto where id_tip =? and auto.availability = 1",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Auto.class));
    }
    public List <Auto> index(String date1, String date2){
        date1 = formatDate(date1);
        date2 = formatDate(date2);
        return jdbcTemplate.query("SELECT * from auto WHERE auto.availability = 1 and  auto.id not in((SELECT appeal.id_auto from appeal WHERE appeal.availability=1))",
                new BeanPropertyRowMapper<>(Auto.class) );    }

    public List <Auto> index(String date1, String date2, int id){
        date1 = formatDate(date1);
        date2 = formatDate(date2);
        return jdbcTemplate.query("SELECT * from auto WHERE auto.availability = 1 and id_tip =? and  auto.id not in((SELECT appeal.id_auto from appeal WHERE appeal.availability=1))",new Object[]{id},
                new BeanPropertyRowMapper<>(Auto.class) );    }

    public static String formatDate(String dateStr){
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String s = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd", new Locale("ru")));
        System.out.println(s);
        return s;

    }
}
