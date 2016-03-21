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

    @RequestMapping("/")
    public String redirectUrlLodin(){
        return "redirect:/login";
    }

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Show(Model model) {
       // long start = System.currentTimeMillis();
       // System.out.println(System.currentTimeMillis()-start);
        return "StartingPage";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String comparisonUser(@RequestParam String password, @RequestParam String username, HttpServletResponse response) throws IOException {
        userService.mapUser.clear();

        if (userService.comparisonUser(password, username) == 0) return "redirect:/MainPage";
        if (userService.comparisonUser(password, username) == 1)return "AdminPage";
        return "redirect:/";
    }
}
