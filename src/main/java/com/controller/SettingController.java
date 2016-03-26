package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingController {

    @RequestMapping("/settings")
    public String ShowSetting(){
        return "Settings";
    }

}
