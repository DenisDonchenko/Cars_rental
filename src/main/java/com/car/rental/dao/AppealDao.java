package com.car.rental.dao;
import com.car.rental.model.Appeal;
import com.car.rental.model.Tip_auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AppealDao {

    private  final JdbcTemplate jdbcTemplate;
    @Autowired
    public AppealDao(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }


    public List<Appeal> index(){
        return  jdbcTemplate.query(
                "SELECT appeal.`id`, concat (auto.marka,' ',auto.model) AS name_car,\n" +
                        "concat(klient.first_name,' ',klient.last_name) as klient_name,\n" +
                        "klient.phone_number, appeal.date_return,\n" +
                        "DATE_FORMAT(appeal.date_issue, '%d.%m.%Y') as date_issue, `place_return`, `place_issue`, appeal.count_day,appeal.price_day,appeal.all_price,\n" +
                        "DATE_FORMAT(appeal.date_return, '%d.%m.%Y') as date_return \n" +
                        "FROM `appeal`\n" +
                        "INNER JOIN  auto on appeal.id_auto = auto.id\n" +
                        "INNER JOIN klient on appeal.id_klient = klient.id\n" +
                            "WHERE appeal.availability = 1 ORDER BY appeal.id  DESC",
                new BeanPropertyRowMapper<>(Appeal.class));
    }
    public void deleteAppeal(int id){
        LocalDate localDate = LocalDate.now();
        jdbcTemplate.update("UPDATE `appeal` SET `availability`=0,`coment`='Бронь скасована' WHERE id = ?",id);
    }
    public void closeAppeal(int id){
        jdbcTemplate.update("UPDATE `appeal` SET `availability`=0, appeal.coment = concat('Бронь закрита ', DATE_FORMAT(now(), '%d.%m.%Y'))  WHERE id = ?",id);
    }
    public List<Appeal> indexArhiw(){
        return  jdbcTemplate.query(
                "SELECT appeal.`id`, concat (auto.marka,' ',auto.model) AS name_car,\n" +
                        "concat(klient.first_name,' ',klient.last_name) as klient_name,\n" +
                        "klient.phone_number,appeal.coment, appeal.date_return,\n" +
                        "DATE_FORMAT(appeal.date_issue, '%d.%m.%Y') as date_issue, `place_return`, `place_issue`, appeal.count_day,appeal.price_day,appeal.all_price,\n" +
                        "DATE_FORMAT(appeal.date_return, '%d.%m.%Y') as date_return \n" +
                        "FROM `appeal`\n" +
                        "INNER JOIN  auto on appeal.id_auto = auto.id\n" +
                        "INNER JOIN klient on appeal.id_klient = klient.id\n" +
                        "WHERE appeal.availability = 0 ORDER BY appeal.id  DESC",
                new BeanPropertyRowMapper<>(Appeal.class));
    }

}
