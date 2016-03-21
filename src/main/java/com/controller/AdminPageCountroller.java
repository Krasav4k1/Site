package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageCountroller {

    @Autowired
    ModelFillingController modelFillingController;
    @Autowired
    UserService userService;

    @RequestMapping("/AdminPage")
    public String ShowAdminPage(){
        return "AdminPage";
    }

    @RequestMapping("/AdminVisit/{id}")
    public String ShowPageUser(Model model,@PathVariable int id){
        userService.comparisonUserVisit(id);
        modelFillingController.FillingModelUser(model);
        return "AdminVisitPage";
    }

}
