package com.controller;

import com.entity.Role;
import com.entity.User;
import com.repository.UserRepository;
import com.servise.CountryService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RegisterUserController {

    @Autowired
    UserService userService;
    @Autowired
    CountryService countryService;
    @Autowired
    CityController cityController;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


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
        userService.save(user);
        return "redirect:/MainPage";
    }

}




