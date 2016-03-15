package com.controller;

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
        userService.comparisonUserVisit(id);
        modelFillingController.FillingModelUser(model);
        return "VisetPage";
    }



}
