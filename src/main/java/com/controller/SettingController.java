package com.controller;

import com.entity.*;
import com.repository.GrupRepository;
import com.repository.UserRepository;
import com.servise.*;
import com.servise.binder.GrupEditor;
import com.servise.binder.UserEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
//@SessionAttributes( value = "User", types={User.class})
public class SettingController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    GrupRepository grupRepository;
    @Autowired
    GrupService grupService;
    @Autowired
    AlbomFotoService albomFotoService;
    @Autowired
    FotoService fotoService;

    @RequestMapping("/settings")
    public String ShowSetting() {
        return "Settings";
    }

 /*   @ModelAttribute("grup")
    public Grup grup(){
        return new Grup();
    }

    @ModelAttribute("grupList")
    public Iterable<Grup> grups(){
        return grupRepository.findAll();
    }

    @ModelAttribute("User")
    public User principalUser(Principal principal){
        User user = userRepository.findOne(Integer.parseInt(principal.getName()));
        return user;
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Grup.class, new GrupEditor(grupService));
        binder.registerCustomEditor(User.class, new UserEditor(userService));
    }

    @RequestMapping(value = "/settings/addGrup", method = RequestMethod.POST)
    public String addGrupFotUset(@ModelAttribute("User") User user){
        userService.editUser(user);
        return "redirect:/settings";
    }
*/



}
