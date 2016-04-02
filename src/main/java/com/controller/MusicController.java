package com.controller;

import com.entity.MusicAlbom;
import com.entity.User;
import com.repository.MusicAlbomRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MusicController {

    @Autowired
    MusicAlbomRepository musicAlbomRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/music")
    public String ShowMusic(Model model, Principal principal){
            model.addAttribute("albomMusicAdd", new MusicAlbom());
            model.addAttribute("userPersistens", userRepository.findOne(Integer.parseInt(principal.getName())));
        return "Music";
    }

    @RequestMapping(value = "/musicAddMusicAlbom" , method = RequestMethod.POST)
    public String addMusicAlbom(@ModelAttribute MusicAlbom musicAlbom){
        System.out.println(musicAlbom.getUser().getFirstName());
        musicAlbomRepository.save(musicAlbom);
    return "Music";
    }
}
