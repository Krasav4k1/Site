package com.controller;

import com.servise.AlbomFotoService;
import com.servise.FileSaveService;
import com.servise.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Controller
public class FotoController {

    @Autowired
    FotoService fotoService;
    @Autowired
    FileSaveService fileSaveService;
    @Autowired
    AlbomFotoService albomFotoServiceImpl;

    @RequestMapping("/albom/{id}/foto")
    public String showFotoPage(@PathVariable("id") int id, Model model, Principal principal){
            model.addAttribute("fotos", fotoService.getAllFotoPrincipal(id));
        return "Foto";
    }


//CatelinaBases
//catelinaHome
    @RequestMapping(value = "/albom/{id}/addFileFoto")
    public String addFileFoto(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Principal principal, @PathVariable("id") int id) throws IOException {
       if( file.getBytes().length >= 10000000){
            return "Завеликий файл";
        }else {
           String absolutePath1 = request.getServletContext().getRealPath("resources");
           String absolutePath2 = "C:\\Users\\Andrii\\EclipseProject\\gfgf\\src\\main\\webapp\\resources";
           String albomeName = albomFotoServiceImpl.getNameAlbom(id);
           String fotoPath = fileSaveService.saveFile("foto",principal.getName(), file, absolutePath1,albomeName);
           fileSaveService.saveFile("foto",principal.getName(), file, absolutePath2,albomeName);
           fotoService.addFoto(fotoPath.substring(50),albomeName, principal);
           System.out.println(absolutePath1);
        }
        return "redirect:/albom/{id}/foto";
    }

}
