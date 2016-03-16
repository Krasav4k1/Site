package com.controller;

import com.servise.CountryService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterUserController {

    @Autowired
    UserService userService;
    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String ShowRegisterPage(Model model) {
        model.addAttribute("countryModel", countryService.getAll());
        return "Register";
    }


    //Registrations User
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String addUserRegister(HttpServletResponse response, @RequestParam String lastName, @RequestParam String firstName,
                                  @RequestParam String password, @RequestParam String passwordRepid, @RequestParam String emailUser,
                                  @RequestParam String day, @RequestParam String mouth, @RequestParam String year) throws IOException {//, @RequestParam String region, @RequestParam String oblast, @RequestParam String country

        if (lastName.equals("") || firstName.equals("") || password.equals("") ||
                passwordRepid.equals("") || emailUser.equals("") ||
                day.equals("") || mouth.equals("") || year.equals("")) {
            return "redirect:/register";
        }

        try {
            int dayInt = Integer.parseInt(day);
            int mouthInt = Integer.parseInt(mouth);
            int yearInt = Integer.parseInt(year);
            if (password.equals(passwordRepid)) {
                userService.addUser(escapeHtml(lastName),escapeHtml( firstName),
                        escapeHtml(password),escapeHtml( emailUser),
                        dayInt, mouthInt, yearInt);//city,region,oblast,country
                return "redirect:/";
            }

        } catch (NumberFormatException e) {
            System.err.println(e);
            return "redirect:/register";
        }

        return "redirect:/register";
    }
}




