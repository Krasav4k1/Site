package com.controller;

import com.entity.AlbomFotoUser;
import com.servise.AlbomFotoService;
import com.servise.FileDeleteService;
import com.servise.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller

public class AlbomController {

    @Autowired
    FotoService fotoService;
    @Autowired
    AlbomFotoService albomFotoServiceImpl;
    @Autowired
    FileDeleteService fileDeleteService;

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
        return albomFotoServiceImpl.getAllAlbomPrincipal(Integer.parseInt(principal.getName()));
    }

    @RequestMapping(value = "/albom/addFotoAlbom", method = RequestMethod.POST)
    public String addFotoAlbom(@Valid @ModelAttribute("AlbomFoto") AlbomFotoUser albomFotoUser, BindingResult br, Principal principal){
        if (br.hasErrors()){
            return "Albom";
        }
        albomFotoServiceImpl.addAlbomFotoForUser(Integer.parseInt(principal.getName()),albomFotoUser);
        return "redirect:/albom";
    }

    @RequestMapping("/albom/daleteById{id}")
    public String removeAlbom(@PathVariable("id") int id, Principal principal,  HttpServletRequest request) throws IOException {
        albomFotoServiceImpl.removeByid(id,request.getServletContext().getRealPath("resources"), principal);
        return "redirect:/albom";
    }


}
