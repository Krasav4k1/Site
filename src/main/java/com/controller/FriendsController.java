package com.controller;

import com.entity.User;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendsController {

    @Autowired
    UserService userService;

    @RequestMapping("/friends")
    public String ShowFriends(){

        return "Friends";
    }
    @ModelAttribute("friends")
    public Iterable<User> frends(){
        return userService.getAll();
    }

}
