package com.car.rental.controller;

import com.car.rental.dao.AdminDao;
import com.car.rental.model.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/autoAdmin")
public class AdminController {
    private final AdminDao adminDao;
        private String uploadPath = "C:/Users/user/Car_Rental/src/main/resources/static/image/auto_photo";

    @Autowired
    public AdminController(AdminDao adminDao){this.adminDao = adminDao;}

    @GetMapping()
    public String index(Model model){
        model.addAttribute("listTip", adminDao.index_tip());
        model.addAttribute("carList",adminDao.showAutoLimit());
        boolean myBooleanVariable = true;
        model.addAttribute("myBooleanVariable", myBooleanVariable);
        return "admin";
    }
    @GetMapping("del/{id}")
    public String delAuto(@PathVariable("id") int id, Model model){
        adminDao.deleteAuto(id);
        return "redirect:/autoAdmin";

    }
    @PostMapping("/editAvailability/{id}" )
    public String editCustomer(@PathVariable("id") int id, @RequestParam(value = "myBooleanVariable", required = false) boolean b)
    {
    adminDao.updateAutoAvailability(id,b);
        return "redirect:/autoAdmin";
    }
    @GetMapping("/{id}")
    public  String show( @PathVariable("id") int id, Model model){
        model.addAttribute("listTip", adminDao.index_tip());
        model.addAttribute("carList", adminDao.showTip(id));
        return "admin";
    }
    @GetMapping("/newForm")
    public String newPerson(@ModelAttribute("auto") Auto auto, Model model) {
        model.addAttribute("listTip", adminDao.index_tip());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("auto") @Valid Auto auto,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("listTip", adminDao.index_tip());
            return "new";
        }
        String foto = "/resources/image/auto_photo/"+auto.getPhoto_auto();
            auto.setPhoto_auto(foto);
        adminDao.saveAuto(doPrice( auto));
        return "redirect:/autoAdmin";
    }
    private Auto doPrice(Auto auto){
        int price1 = (int) ( auto.getPrice_rental() * ((100 - auto.getPercent()) / 100));
        int price2 = (int) ( price1 * ((100 - auto.getPercent()) / 100));
        int price3 = (int) ( price2 * ((100 - auto.getPercent()) / 100));
        int price4 = (int) ( price3 * ((100 - auto.getPercent()) / 100));
        int price5 = (int) ( price4 * ((100 - auto.getPercent()) / 100));
        auto.setPrice2(price2);
        auto.setPrice1(price1);
        auto.setPrice3(price3);
        auto.setPrice4(price4);
        auto.setPrice5(price5);
        return auto;
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("auto", adminDao.show(id));
        model.addAttribute("listTip", adminDao.index_tip());
        return "edit";
    }
    @PatchMapping("/go/{id}")
    public String update(@ModelAttribute("auto") @Valid Auto auto, BindingResult bindingResult,
                         @PathVariable("id") int id,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listTip", adminDao.index_tip());
            return "edit";
        }
        String foto = "/resources/image/auto_photo/"+auto.getPhoto_auto();
        auto.setPhoto_auto(foto);
        adminDao.updateAuto(id, doPrice( auto));
        return "redirect:/autoAdmin";
    }

}
