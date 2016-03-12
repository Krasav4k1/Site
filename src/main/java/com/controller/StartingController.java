package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartingController {

    @RequestMapping("/")
    public String Show() {return "StartingPage";}



}
