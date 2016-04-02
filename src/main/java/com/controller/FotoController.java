package com.controller;

import com.servise.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class FotoController {

    @Autowired
    FotoService fotoService;

    @RequestMapping("/albom/{id}/foto")
    public String showFotoPage(@PathVariable("id") int id, Model model, Principal principal){
            model.addAttribute("fotos", fotoService.getAllFotoPrincipal(principal, id));
        return "Foto";
    }




}
