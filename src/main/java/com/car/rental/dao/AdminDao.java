package com.car.rental.dao;

import com.car.rental.model.Auto;
import com.car.rental.model.Tip_auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Tip_auto> index_tip(){
        return  jdbcTemplate.query("select * from tip_auto ;",
                new BeanPropertyRowMapper<>(Tip_auto.class));
    }
    public List<Auto> showAuto(){
        return  jdbcTemplate.query("select * from auto",
                new BeanPropertyRowMapper<>(Auto.class));
    }
    public List<Auto> showAuto(int id){
        return jdbcTemplate.query("select * from auto where id =? ",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Auto.class));
    }
    public Auto show(int id) {
        return jdbcTemplate.query("select * from auto where id =?", new Object[]{id}, new BeanPropertyRowMapper<>(Auto.class))
                .stream().findAny().orElse(null);
    }
    public void deleteAuto(int id){
        jdbcTemplate.update("DELETE FROM `auto` WHERE `auto`.`id` = ?",id);
    }
    public List<Auto> showAutoLimit(){
        return jdbcTemplate.query("SELECT * FROM `auto` ORDER BY `auto`.`id`  DESC LIMIT 10",
                new BeanPropertyRowMapper<>(Auto.class));
    }
    public  List <Auto> showTip(int id){
        return jdbcTemplate.query("select * from auto where id_tip =? ",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Auto.class));
    }
    public void saveAuto(Auto auto){
        String query = "INSERT INTO `auto`( `id_tip`, `marka`, `model`, `age`, `photo_auto`, `price_rental`, " +
                "`fuel_tupe`, `count_passenger`, `engine_volume`, `tip_transmission`," +
                "`percent`, `tip_unit`, `availability`,`price1`,`price2`,`price3`,`price4`,`price5`) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,auto.getTip(),auto.getMarka(),auto.getModel(),auto.getAge(),auto.getPhoto_auto()
                            ,auto.getPrice_rental(),auto.getFuel_tupe(),auto.getCount_passenger(),auto.getEngine_volume()
                            ,auto.getTip_transmission(),auto.getPercent(),auto.getTip_unit(),auto.getAvailability(),auto.getPrice1()
                ,auto.getPrice2(),auto.getPrice3(),auto.getPrice4(),auto.getPrice5());

    }
    public void updateAuto(int id, Auto auto) {
        jdbcTemplate.update("UPDATE `auto` SET `id_tip`=?,`marka`=?,`model`=?,`age`=?," +
                        "`photo_auto`=?,`price_rental`=?,`fuel_tupe`=?,`count_passenger`=?," +
                        "`engine_volume`=?,`tip_transmission`=?," +
                        "`percent`=?,`tip_unit`=?,`availability`=?," +
                        "`price1`=?,`price2`=?,`price3`=?,`price4`=?,`price5`=? WHERE id = ?",
                auto.getTip(),auto.getMarka(),auto.getModel(),auto.getAge(),auto.getPhoto_auto()
                ,auto.getPrice_rental(),auto.getFuel_tupe(),auto.getCount_passenger(),auto.getEngine_volume()
                ,auto.getTip_transmission(),auto.getPercent(),auto.getTip_unit(),auto.getAvailability()
                ,auto.getPrice1(),auto.getPrice2(),auto.getPrice3(),auto.getPrice4(),auto.getPrice5(), id);
    }



}
