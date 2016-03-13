package com.controller;

import com.repository.UserRepository;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = {"/VisitUser/id{id}","/MainPage"})
    public String ShowUserPrivate ( Model model ) {
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
        return "MainPage";
    }


    @RequestMapping(value = "/id{id}", method = RequestMethod.GET)
    public String ShowUserVIsit (@PathVariable("id") int email) {
        userService.mapUser.clear();
        userService.comparisonUserVisit(email);
            return "redirect:/VisitUser/id{id}";
    }




}
