package com.controller;

import com.repository.UserRepository;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterUserController {

    @Autowired
    UserService userService;


    @RequestMapping("/Register")
    public String ShowRegisterPage() {
        return "Register";
    }


    //Registrations User
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String addUserRegister(HttpServletResponse response, @RequestParam String lastName, @RequestParam String firstName,
                                  @RequestParam String password, @RequestParam String passwordRepid, @RequestParam String emailUser, @RequestParam String age,
                                  @RequestParam String day, @RequestParam String mouth, @RequestParam String year) throws IOException {//, @RequestParam String region, @RequestParam String oblast, @RequestParam String country

        if (lastName.equals("") || firstName.equals("") || password.equals("") ||
                passwordRepid.equals("") || emailUser.equals("") || age.equals("") ||
                day.equals("") || mouth.equals("") || year.equals("")) {
            return "redirect:/Register";
        }

        try {
            int ageInt = Integer.parseInt(age);
            int dayInt = Integer.parseInt(day);
            int mouthInt = Integer.parseInt(mouth);
            int yearInt = Integer.parseInt(year);
            if (password.equals(passwordRepid)) {
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




