package com.controller;

import com.entity.AlbomFotoUser;
import com.entity.Foto;
import com.repository.FotoRepository;
import com.servise.AlbomFotoService;
import com.servise.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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
    public String addFotoAlbom(@Valid @ModelAttribute("AlbomFoto") AlbomFotoUser albomFotoUser, BindingResult br, Principal principal){
        if (br.hasErrors()){
            return "Albom";
        }
        albomFotoService.addAlbomFotoForUser(Integer.parseInt(principal.getName()),albomFotoUser);
        return "redirect:/albom";
    }

    @RequestMapping("/albom/daleteById{id}")
    public String removeAlbom(@PathVariable("id") int id, Principal principal) throws IOException {
        albomFotoService.removeByid(id, principal);
        return "redirect:/albom";
    }


}
