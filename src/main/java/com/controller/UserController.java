package com.controller;

import com.repository.UserRepository;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = {"/{url}/id{id}","/{url}"})
    public String ShowUserPrivate ( Model model , @PathVariable String url) {

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
        if (url.equals("MainPage")){
            return "MainPage";
        }
        if (url.equals("VisitUser")){
            return "VisetPage";
        }
        if (url.equals("AdminVisit")){
            return "AdminVisitPage";
        }
        return "ErrorPage";
    }


    @RequestMapping(value = {"/id{id}","/AdminVisit/id{id}"}, method = RequestMethod.GET)
    public String ShowUserVIsit (@PathVariable("id") int id) {
        userService.mapUser.clear();
        userService.comparisonUserVisit(id);
            return "redirect:/VisitUser/id{id}";
    }




}
