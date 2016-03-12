package com.controller;

import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String Show(Model model) {
        model.addAttribute("users", userService.getAll());
        System.out.println("start Page");
        return "StartingPage";

    }

    @RequestMapping("/{id}")
    public String dalete(@PathVariable String id){
        userService.dalete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String comparisonUser (@RequestParam String password, @RequestParam String emailUser, Model model) {
        if (userService.comparisonUser(password,emailUser) == 0){
            model.addAttribute("firstNameMap", userService.mapUser.get("firstName"));
            model.addAttribute("lastNameMap", userService.mapUser.get("lastName"));
            model.addAttribute("ageMap", userService.mapUser.get("age"));
            model.addAttribute("dayMap", userService.mapUser.get("day"));
            model.addAttribute("mouthMap", userService.mapUser.get("mouth"));
            model.addAttribute("yearMap", userService.mapUser.get("year"));
            model.addAttribute("cityMap", userService.mapUser.get("city"));
            model.addAttribute("ragionMap", userService.mapUser.get("region"));
            model.addAttribute("oblastMap", userService.mapUser.get("oblast"));
            model.addAttribute("countryMap", userService.mapUser.get("country"));
            return "MainPage";
        }else if (userService.comparisonUser(password,emailUser) == 1){
            return "AdminPage";
        }else if (userService.comparisonUser(password,emailUser) == 9) {
            return "ErrorEntrance";
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
                                   @RequestParam String day, @RequestParam String mouth, @RequestParam String year) throws IOException {//, @RequestParam String region, @RequestParam String oblast, @RequestParam String country
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
