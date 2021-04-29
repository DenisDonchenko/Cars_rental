package com.car.rental.controller;

import com.car.rental.dao.KlientDao;
import com.car.rental.model.Appeal;
import com.car.rental.model.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
@RequestMapping("/klient")
public class KlientController {
    private  final KlientDao klientDAO;
    private int id_Auto;
    private  String date1;
    private  String date2;
    private int priceDay;
    private int count_day;
    @Autowired
    public KlientController(KlientDao klientDAO){
        this.klientDAO = klientDAO;
    }
    private static String formatDate(String dateStr){
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String s = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd", new Locale("ru")));
        return s;

    }
    @GetMapping
    public String index(){
        return"rentalForma";
    }
    @RequestMapping()
    public  String index(Model model,
                         @RequestParam("idAuto") int id,
                         @RequestParam("countdate") int countDays,
                         @RequestParam("dateOnes") String date1,
                         @RequestParam("dateTwos") String date2){
        this.date1=date1;
        this.date2=date2;
        this.id_Auto = id;
        this.count_day = countDays;
         priceDay = showPrices(countDays, id);
        int priceAllDay = priceDay * countDays;
        model.addAttribute("autoOne",klientDAO.showAuto(id,countDays));
        model.addAttribute("autoPrice",priceDay);
        model.addAttribute("autoAllprice",priceAllDay);

        return "rentalForma";

    }
    @PostMapping("/new")
    public String create(
            @RequestParam("first_name") String f_name,
            @RequestParam("last_name") String l_name,
            @RequestParam("patronymic")  String patronymic,
            @RequestParam("phone_number") String phone_number,
            @RequestParam("return") String place_return,
            @RequestParam("issue") String place_issue ){
        LocalDate localDate1 = LocalDate.parse(formatDate(date1));
        LocalDate localDate2 = LocalDate.parse(formatDate(date2));

        int id_klient = 0;
        Klient klient = new Klient(f_name,l_name,patronymic,phone_number);
        if (klientDAO.is_Klient(klient)  == null){
            klientDAO.save(klient);
        }

        id_klient = klientDAO.showKlientId(phone_number).getId();


        Appeal appeal = new Appeal(id_Auto,id_klient,localDate1.toString(),
                place_return,localDate2.toString(),place_issue,count_day, priceDay,count_day*priceDay);
        klientDAO.saveAppel(appeal);
        return "exitForm";
    }

    private int showPrices(int countDays,int id){
        int x = 0;
        if(countDays==1 || countDays==2){
            x = klientDAO.showAuto(id,countDays).getPrice_rental();
        }else if (countDays>=3 && countDays<=5){
            x = klientDAO.showAuto(id,countDays).getPrice1();
        }else if (countDays==6 || countDays==7){
            x = klientDAO.showAuto(id,countDays).getPrice2();
        }else if (countDays>=8 && countDays<=14){
            x = klientDAO.showAuto(id,countDays).getPrice3();
        }else if (countDays>=15 && countDays<=28){
            x = klientDAO.showAuto(id,countDays).getPrice4();
        }else if (countDays>=29){
            x = klientDAO.showAuto(id,countDays).getPrice5();
        }
        return x;
    }
}
