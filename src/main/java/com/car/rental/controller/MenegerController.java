package com.car.rental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meneger")
public class MenegerController {

    @GetMapping()
    public String index(){


        return "menegerCar";
    }
}
