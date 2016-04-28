package com.controller;

import com.entity.Messages;
import com.entity.User;
import com.servise.FrendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MessageController {

    @Autowired
    FrendsService frendsService;

    @RequestMapping("/message")
    public String ShowMessage(){
        return "Message";
    }

    @ModelAttribute("getAllUserForMessegerPage")
    public Iterable<User> getAllUserForMessegerPage(Principal principal){
        return frendsService.getFrends(principal,1,1,1);
    }

    @RequestMapping("sendMessegerAndUpdate{resiverUser}.json")
    public @ResponseBody Iterable<Messages> sendMessegerAndUpdate(@PathVariable('resiverUser') int resiverUser){
        resiverUser = 0;
        return null;
    }

}
