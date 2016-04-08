package com.controller;

import com.entity.MusicAlbom;
import com.entity.User;
import com.repository.MusicAlbomRepository;
import com.repository.UserRepository;
import org.mortbay.servlet.MultiPartFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
public class MusicController {

    @Autowired
    MusicAlbomRepository musicAlbomRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/music")
    public String ShowMusic(Model model, Principal principal){
        return "Music";
    }

    @RequestMapping(value = "/musicUplodate", method = RequestMethod.POST)
    public String addMusic(@RequestParam("files")MultipartFile file){
        System.out.println("1234567890-==-09876543211234567890-==--=-098765432");
        return "redirect:/music";
    }

}
