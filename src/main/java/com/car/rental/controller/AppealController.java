package com.car.rental.controller;

import com.car.rental.dao.AppealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/appeal")
public class AppealController {
    private  final AppealDao appealDao;
    @Autowired
    public AppealController(AppealDao appealDao){ this.appealDao = appealDao;}

    @GetMapping
    public String index(Model model){

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        model.addAttribute("appealList",appealDao.index());
        return "menegerCar";
    }
    @GetMapping("/{id}")
    public  String closeApp(@PathVariable("id") int id){
        appealDao.closeAppeal(id);
        return "redirect:/appeal";
    }
    @GetMapping("/del/{id}")
    public  String deleteAppeal(@PathVariable("id") int id){
        appealDao.deleteAppeal(id);
        return "redirect:/appeal";
    }
    @GetMapping("/arhiw")
    public  String indexArhiw(Model model){
        model.addAttribute("appealList",appealDao.indexArhiw());
        return "arhiw";
    }

}
