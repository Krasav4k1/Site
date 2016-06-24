package com.controller;

import com.repository.GrupRepository;
import com.repository.UserRepository;
import com.servise.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
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
    @Autowired
    FileDeleteService fileDeleteService;

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

    @RequestMapping(value = "/settings/daleteUser",method = RequestMethod.GET)
    public String removeUser(Principal principal) throws IOException {
//        albomFotoService.removeByid(Integer.parseInt(principal.getName()),principal);

        userService.dalete(principal.getName());
        return null;
    }

}
