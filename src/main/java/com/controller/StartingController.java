package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartingController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String redirectUrlLogin(){
        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String Show(Model model) {
        return "StartingPage";
    }


}
