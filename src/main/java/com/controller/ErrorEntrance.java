package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ErrorEntrance {

    @RequestMapping("/ErrorEntrance")
    public String ShowErrorEntrance(){
        return "ErrorEntrance";
    }


}
