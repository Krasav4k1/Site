package com.controller;

import com.entity.Frends;
import com.entity.User;
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
        User user = userService.findById(Integer.parseInt(principal.getName()));
        Frends frend = new Frends();
        frend.setUserSend(user);
        frend.setUserRecived(userService.findById(id));
        frend.setRecivedFrendsip(1);
        frend.setSendFrendship(1);
        frend.setSpesialStatys(1);
/*        List<Frends> f = new ArrayList<Frends>();
        f.add(frend);
        user.setSendFrendses(f);
        userService.save(user);*/
        frendsService.save(frend);
        System.out.println(id+"доданий");
        return "redirect:/id{id}";
    }

    @RequestMapping("/daleteFrend/{id}")
    public String daleteFriend(@PathVariable("id") int id, Principal principal){
        User user = userService.findById(Integer.parseInt(principal.getName()));
/*        for (Frends friends: user.getSendFrendses()){
            if (id == friends.getUserRecived().getId()){
                friends.setUserSend(null);
                friends.setUserRecived(null);
                frendsService.daleteByIdLine(friends);
                break;
            }
            break;
        }*/

        return "redirect:/id{id}";
    }




}
