package com.controller;

import com.servise.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    @RequestMapping(method = RequestMethod.GET)
    public String ShowForgotPassword(){

        return "ForgotPassword";
    }
}


