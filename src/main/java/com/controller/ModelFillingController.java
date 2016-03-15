package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class ModelFillingController {

    @Autowired
    UserService userService;

    public void FillingModelUser(Model model){
        model.addAttribute("firstNameMap", userService.mapUser.get("firstName"));
        model.addAttribute("lastNameMap", userService.mapUser.get("lastName"));
        model.addAttribute("ageMap", userService.mapUser.get("age"));
        model.addAttribute("dayMap", userService.mapUser.get("day"));
        model.addAttribute("mouthMap", userService.mapUser.get("mouth"));
        model.addAttribute("yearMap", userService.mapUser.get("year"));
        model.addAttribute("cityMap", userService.mapUser.get("city"));
        model.addAttribute("ragionMap", userService.mapUser.get("region"));
        model.addAttribute("oblastMap", userService.mapUser.get("oblast"));
        model.addAttribute("countryMap", userService.mapUser.get("country"));
    }

}

