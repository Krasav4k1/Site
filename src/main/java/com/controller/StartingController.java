package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StartingController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String Show() {
        return "StartingPage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String comparisonUser(@RequestParam String password, @RequestParam String emailUser, HttpServletResponse response) throws IOException {
        userService.mapUser.clear();
        if (userService.comparisonUser(password, emailUser) == 0) {
            return "redirect:/MainPage";
        }
        if (userService.comparisonUser(password, emailUser) == 1){
            return "AdminPage";
        }
        return "ErrorEntrance";
    }
}
