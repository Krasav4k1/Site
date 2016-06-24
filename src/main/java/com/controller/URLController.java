package com.controller;

import com.repository.UserRepository;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller

public class URLController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    @RequestMapping("/accessDenied")
    public ModelAndView accessDenied(Principal user){

        ModelAndView model = new ModelAndView();
        if (user != null){
            model.addObject("errorMsg", userRepository.findOne(Integer.parseInt(user.getName())).getLastName() + " " +
                    userRepository.findOne(Integer.parseInt(user.getName())).getFirstName()
                    + " У вас нема доступа до цієї сторінки");
        }else{
            model.addObject("errorMsg", "У вас нема доступа до цієї сторінки");
        }
        model.setViewName("AccessDenied");

        return model;
    }


}

