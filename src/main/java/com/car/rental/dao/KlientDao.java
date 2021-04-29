package com.car.rental.dao;

import com.car.rental.model.Appeal;
import com.car.rental.model.Auto;
import com.car.rental.model.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class KlientDao {
    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public KlientDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate =jdbcTemplate;
    }

    public Auto showAuto(int id,long countDays){
        return  jdbcTemplate.query("select * from auto where id =? ",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Auto.class))
                .stream().findAny().orElse(null);
    }
    public void save(Klient klient){
        jdbcTemplate.update(
                "INSERT INTO `klient`(`first_name`, `last_name`, `patronymic`, `phone_number`) VALUES (?,?,?,?)",
                klient.getFirst_name(),klient.getLast_name(),klient.getPatronymic(),klient.getPhone_number());
    }
    public Klient showKlientId(String phone){
        return  jdbcTemplate.query("select * from klient where phone_number =? ",
                new Object[]{phone},
                new BeanPropertyRowMapper<>(Klient.class))
                .stream().findAny().orElse(null);
    }
    public Klient is_Klient (Klient klient){
        return  jdbcTemplate.query("select * from klient where phone_number =? ",
                new Object[]{klient.getPhone_number()},
                new BeanPropertyRowMapper<>(Klient.class))
                .stream().findAny().orElse(null);
    }
    public void saveAppel(Appeal appeal){
        String query = "INSERT INTO `appeal` ( `id_auto`, `id_klient`, `date_return`, " +
                "`date_issue`, `place_return`, `place_issue`, `count_day`, `price_day`, `all_price`)  VALUES" +
                " (?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,appeal.getId_auto(), appeal.getId_klient(),
                appeal.getDate_return(),appeal.getDate_issue(),
                appeal.getPlace_return(), appeal.getPlace_issue(),appeal.getCount_day(),appeal.getPrice_day(),appeal.getAll_price());

    }
}

