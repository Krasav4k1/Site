package com.controller;

import com.entity.User;
import com.repository.UserRepository;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VisitUserControlleer {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    ModelFillingController modelFillingController;

    @RequestMapping("/VisitUser")
    public String ShowVisitUser(Model model) {
        modelFillingController.FillingModelUser(model);
        return "VisetPage";
    }
    @RequestMapping("/id{id}")
    public String ShowVisitUser1 (@PathVariable int id,Model model) {
        User owner = userRepository.findOne(id);
        if ( owner == null ){
            return "NonUser";
        }
        model.addAttribute("user", owner);
        userService.comparisonUserVisit(id);
        modelFillingController.FillingModelUser(model);
        return "MainPage";
    }



}
