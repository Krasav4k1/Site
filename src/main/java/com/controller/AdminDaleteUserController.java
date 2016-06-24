package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminDaleteUserController {

    @Autowired
    UserService userService;

    @RequestMapping("/AdminPage/AdminDaleteUser")
    public String Show(Model model) {
        model.addAttribute("users", userService.getAll());
        return "AdminDaleteUser";
    }


    @RequestMapping("/AdminPage/AdminDaleteUser/{id}")
    public String dalete(@PathVariable String id){
        userService.dalete(id);
        return "redirect:/AdminDaleteUser";
    }


}
