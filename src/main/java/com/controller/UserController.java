package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    ModelFillingController modelFillingController;

    @Autowired
    UserService userService;

    @RequestMapping("/MainPage")
    public String ShowMainPage(Model model, Principal principal){
        if (principal != null){
            return "redirect:/id" + principal.getName();
        }
        return "redirect:/";
//        modelFillingController.FillingModelUser(model);
//        return "MainPage";
    }


}
