package com.controller;

import com.entity.AlbomFotoUser;
import com.entity.Foto;
import com.repository.FotoRepository;
import com.servise.AlbomFotoService;
import com.servise.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class AlbomController {

    @Autowired
    FotoService fotoService;
    @Autowired
    AlbomFotoService albomFotoService;

    @RequestMapping("/albom")
    public String showFotoPage(){
        return "Albom";
    }

    @ModelAttribute("AlbomFoto")
    public AlbomFotoUser albomFoto(){
        return new AlbomFotoUser();
    }

    @ModelAttribute("AlbomFotoList")
    public Iterable<AlbomFotoUser> albomFotos(Principal principal){
        return albomFotoService.getAllAlbomPrincipal(Integer.parseInt(principal.getName()));
    }

    @RequestMapping(value = "/albom/addFotoAlbom", method = RequestMethod.POST)
    public String addFotoAlbom(@ModelAttribute("AlbomFoto") AlbomFotoUser albomFotoUser, Principal principal){
        albomFotoService.addAlbomFotoForUser(Integer.parseInt(principal.getName()),albomFotoUser);
        return "redirect:/albom";
    }

    @RequestMapping("/albom/daleteById{id}")
    public String removeAlbom(@PathVariable("id") int id){
        System.out.println("wuvgwuvg");
        albomFotoService.removeByid(id);
        return "redirect:/albom";
    }


}
