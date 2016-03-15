package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class URLController {

    @Autowired
    UserService userService;


    @RequestMapping(value = {"/{url}/id{id}","/{url}"})
    public String ShowUserPrivate (Model model , @PathVariable String url) {
        userService.mapUser.clear();
        if (url.equals("MainPage")) return "redirect:/MainPage";
        if (url.equals("VisitUser"))return "redirect:/VisitUser";
        if (url.equals("register")) return "redirect:/register";
        if (url.equals("forgot-Password")) return "redirect:/forgotPassword";
        return "ErrorPage";

    }

}
