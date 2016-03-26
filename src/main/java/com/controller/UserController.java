package com.controller;

import com.entity.User;
import com.repository.UserRepository;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    ModelFillingController modelFillingController;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/MainPage")
    public String ShowMainPage(Model model, Principal principal){
        if (principal != null){
            return "redirect:/id" + principal.getName();
        }
        return "redirect:/";
    }

    @RequestMapping("/id{id}")
    public String ShowMainPageForRoler (@PathVariable int id, Model model) {
        User owner = userRepository.findOne(id);
        if ( owner == null ){
            return "NonUser";
        }

        model.addAttribute("user", owner);
        modelFillingController.FillingModelUser(model);
        return "MainPage";
    }

}
