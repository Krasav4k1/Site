package com.controller;

import com.entity.User;
import com.repository.FrendsRepository;
import com.servise.FrendsService;
import com.servise.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class FriendsController {

    @Autowired
    FrendsService frendsService;
    @Autowired
    UserService userService;
    @Autowired
    FrendsRepository frendsRepository;

    @RequestMapping("/friends")
    public String ShowFriends(){
        return "Friends";
    }

    @ModelAttribute("friends")
    public List<User> frends(Principal principal){
       return frendsService.getFrends(principal,1,1,0);
    }

    @RequestMapping( value = "/addFriends/{id}", method = RequestMethod.GET)
    public String addFrend(@PathVariable("id") int id, Model model,Principal principal){
        frendsService.addFrend(principal,id);
        return "redirect:/id{id}";
    }

    @RequestMapping("/daleteFrend/{id}")
    public String daleteFriend(@PathVariable("id") int id, Principal principal){
        frendsService.daleteFrends(principal,id);
        return "redirect:/id{id}";
    }

    @RequestMapping("getAllPeople.json")
    public @ResponseBody Iterable<User> getAllPeople(){
        Hibernate.initialize(userService.getAll());
        return userService.getAll();
    }

    @RequestMapping("/getMyFrends.json")
    public @ResponseBody Iterable<User> myFrends(Principal principal){
        return frendsService.getFrends(principal,1,1,0);
    }


}
