package com.controller;

import com.entity.User;
import com.servise.CountryService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterUserController {

    @Autowired
    UserService userService;
    @Autowired
    CountryService countryService;
//    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    MailSenderService mailSenderService;


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String ShowRegisterPage(Model model) {
        model.addAttribute("countryModel", countryService.getAll());
        return "Register";
    }

    @ModelAttribute("userObject")
    public User setUser(){
        return new User();
    }

    @RequestMapping(value = "/register=user+add",method = RequestMethod.POST)
    public String regigisterUser(@Valid @ModelAttribute("userObject") User user, BindingResult br, Model model){
        if (br.hasErrors()){
            model.addAttribute("countryModel", countryService.getAll());
            return "Register";
        }
//        mailSenderService.sendMail("register",user.getEmail(),"qwertyasdfghzxcvbn");
        userService.save(user);
        return "redirect:/MainPage";
    }


}




