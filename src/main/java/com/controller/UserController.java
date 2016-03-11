package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/")
    public String Show() {
        System.out.println("start Page");
        return "StartingPage";

    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String comparisonUser (@RequestParam String password, @RequestParam String emailUser, Model model) {
        if (userService.comparisonUser(password,emailUser)){
            model.addAttribute("firstNameMap", userService.mapUser.get("firstName"));
            model.addAttribute("lastNameMap", userService.mapUser.get("lastName"));
            model.addAttribute("ageMap", userService.mapUser.get("age"));
            model.addAttribute("dayMap", userService.mapUser.get("day"));
            model.addAttribute("mouthMap", userService.mapUser.get("mouth"));
            model.addAttribute("yearMap", userService.mapUser.get("year"));
            return "MainPage";
        }
        return "ErrorEntrance";

    }

    @RequestMapping("/Register")
    public String ShowRegister() {
        return "Register";
    }
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String addUserRegister (HttpServletResponse response, @RequestParam String lastName, @RequestParam String firstName,
                                   @RequestParam String password, @RequestParam String passwordRepid,@RequestParam String emailUser, @RequestParam String age,
                                   @RequestParam String day, @RequestParam String mouth, @RequestParam String year,@RequestParam String city) throws IOException {//, @RequestParam String region, @RequestParam String oblast, @RequestParam String country
        if (lastName.equals("") || firstName.equals("") || password.equals("") ||
                passwordRepid.equals("") || emailUser.equals("") || age.equals("") ||
                day.equals("") || mouth.equals("") || year.equals("")){
            return "redirect:/Register";
        }
        try {
            int ageInt = Integer.parseInt(age);
            int dayInt = Integer.parseInt(day);
            int mouthInt = Integer.parseInt(mouth);
            int yearInt = Integer.parseInt(year);
            if(password.equals(passwordRepid)) {
                userService.addUser(lastName, firstName, password, emailUser, ageInt, dayInt, mouthInt, yearInt);//city,region,oblast,country
                response.sendRedirect("/");
                return "StartingPage";
            }
        } catch (NumberFormatException e) {
            System.err.println(e);
            return "Register";
        }


        return "redirect:/Register";
    }

}
