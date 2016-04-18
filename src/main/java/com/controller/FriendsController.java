package com.controller;

import com.entity.Frends;
import com.entity.User;
import com.repository.FrendsRepository;
import com.servise.FrendsService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
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
//        System.out.println(frendsService.getFrends(principal,1,1,0).iterator().next().getFirstName());
       return frendsService.getFrends(principal,1,1,0);
    }

    @RequestMapping( value = "/addFriends/{id}", method = RequestMethod.GET)
    public String addFrend(@PathVariable("id") int id, Model model,Principal principal){
        User user = userService.findById(Integer.parseInt(principal.getName()));
        Frends frend = new Frends();
        frend.setUserSend(user);
        frend.setUserRecived(userService.findById(id));
        frend.setRecivedFrendsip(1);
        frend.setSendFrendship(1);
        frend.setSpesialStatys(1);
        frendsService.save(frend);
        return "redirect:/id{id}";
    }

    @RequestMapping("/daleteFrend/{id}")
    public String daleteFriend(@PathVariable("id") int id, Principal principal){
        User user = userService.findById(Integer.parseInt(principal.getName()));
        Frends friends = frendsService.findRecivedAndSend(id,user.getId());
        Frends friends2 = frendsService.findRecivedAndSend(user.getId(),id);
        if (friends != null){
            friends.setUserSend(null);
            friends.setUserRecived(null);
            frendsService.daleteByObjectLine(friends);
            frendsRepository.delete(friends.getId());
        }else if(friends2 != null){
            friends2.setUserSend(null);
            friends2.setUserRecived(null);
            frendsService.daleteByObjectLine(friends2);
            frendsRepository.delete(friends2.getId());
        }
        return "redirect:/id{id}";
    }




}
