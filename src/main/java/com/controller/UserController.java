package com.controller;

import com.entity.Frends;
import com.entity.User;
import com.repository.FrendsRepository;
import com.repository.UserRepository;
import com.servise.FrendsService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FrendsService frendsService;

    @RequestMapping("/MainPage")
    public String ShowMainPage(Model model, Principal principal){
        if (principal != null){
            return "redirect:/id" + principal.getName();
        }
        return "redirect:/";
    }

    @RequestMapping("/id{id}")
    public String ShowMainPageForRoler (@PathVariable int id, Model model, Principal principal) {
        User owner = userRepository.findOne(id);
        if ( owner == null ){
            return "NonUser";
        }
        userService.updateUser(id);
        model.addAttribute("user", owner);
        auditOnFrenship(principal,owner,model);
        return "MainPage";
    }

    private void auditOnFrenship(Principal principal, User user, Model model) {
        if (frendsService.findRecivedAndSend(user.getId(),Integer.parseInt(principal.getName())) != null){
            model.addAttribute("friendsPresent", true);
        }else if(frendsService.findRecivedAndSend(Integer.parseInt(principal.getName()),user.getId()) != null){
            model.addAttribute("friendsPresent", true);
        }

    }


}
