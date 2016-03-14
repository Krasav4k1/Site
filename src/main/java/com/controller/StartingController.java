package com.controller;

import com.repository.CityRepository;
import com.servise.CityService;
import com.servise.CountryService;
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
    @Autowired
    CountryService countryService;
    @Autowired
    CityService cityService;

    @RequestMapping("/")
    public String Show(Model model) {
        model.addAttribute("country", countryService.getAll());
        return "StartingPage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String comparisonUser(Model model,@RequestParam int countryM,@RequestParam String password, @RequestParam String emailUser, HttpServletResponse response) throws IOException {
        userService.mapUser.clear();

        System.out.println(countryM);
        if (userService.comparisonUser(password, emailUser) == 0) {
            return "redirect:/MainPage";
        }
        if (userService.comparisonUser(password, emailUser) == 1){
            return "AdminPage";
        }

        return "ErrorEntrance";
    }
}
