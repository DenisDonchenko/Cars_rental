package com.car.rental.controller;


import com.car.rental.dao.AutoDao;
import com.car.rental.dao.TipAutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
@RequestMapping("")
public class AutoController {
    private  String date1;
    private  String date2;
    private Long countDays;
    @Autowired
    private  AutoDao autoDAO;
    @Autowired
    private TipAutoDao tipAutoDao;

    private void diffInDays() {
        LocalDate localDate1 = LocalDate.parse(autoDAO.formatDate(date1));
        LocalDate localDate2 = LocalDate.parse(autoDAO.formatDate(date2));
        countDays =  DAYS.between(localDate1, localDate2);
        System.out.println("Days"+countDays);
    }

    @GetMapping
    public String index(){
        return "index";
    }
    @RequestMapping("/auto")
    public  String index(Model model,
                         @RequestParam("date_return") String date_return,
                         @RequestParam("date_issue") String date_issue){
        this.date1 = date_issue;
        this.date2 = date_return;
        diffInDays();
        model.addAttribute("autoAll",autoDAO.index(date_return,date_issue));
        model.addAttribute("dateOne",date_issue);
        model.addAttribute("dateTwo",date_return);
        model.addAttribute("countdate",countDays);
        model.addAttribute("tip_autoAll",tipAutoDao.index_tip());
        return "autoCards";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        diffInDays();
        model.addAttribute("autoAll",autoDAO.index(date1,date2,id));
        model.addAttribute("dateOne",date1);
        model.addAttribute("dateTwo",date2);
        model.addAttribute("countdate",countDays);
        model.addAttribute("tip_autoAll",tipAutoDao.index_tip());
        return "autoCards";
    }

    @GetMapping("/all")
    public String showAll( Model model) {
        model.addAttribute("autoAll",autoDAO.index(date1,date2));
        model.addAttribute("tip_autoAll",tipAutoDao.index_tip());
        return "autoCards";
    }
}
