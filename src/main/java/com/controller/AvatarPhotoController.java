package com.controller;

import com.entity.AvatarPhoto;
import com.servise.AvatarPhotoService;
import com.servise.FileSaveService;
import org.mortbay.servlet.MultiPartFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Controller
public class AvatarPhotoController {

    @Autowired
    AvatarPhotoService avatarPhotoService;
    @Autowired
    FileSaveService fileSaveService;

    @ModelAttribute("avatarPhotoList")
    public Iterable<AvatarPhoto> getAllAvatarPhoto(Principal principal){
        return avatarPhotoService.getAllByIdUser(Integer.parseInt(principal.getName()));
    }

    @RequestMapping(value = "/id{id}/addFileAvatarFoto")
    public String addAvatarPhoto(@RequestParam("file") MultipartFile file,@PathVariable("id")int id, HttpServletRequest request, Principal principal) throws IOException{
        if( file.getBytes().length >= 10000000){
            return "Завеликий файл";
        }else {
            String absolutePath1 = request.getServletContext().getRealPath("resources");
            String absolutePath2 = "C:\\Users\\Andrii\\EclipseProject\\gfgf\\src\\main\\webapp\\resources";
            String albomeName = "avatar";
            String fotoPath = fileSaveService.saveFile("foto",principal.getName(), file, absolutePath1,albomeName);
            fileSaveService.saveFile("foto",principal.getName(), file, absolutePath2,albomeName);
            avatarPhotoService.addFoto(fotoPath.substring(50), principal);
            System.out.println(absolutePath1);
        }
        return "redirect:/id{id}";
    }

    @RequestMapping("/id{id}/deleFileAvatarFoto{idFoto}")
    public String deleFileAvatarFoto(@PathVariable("id") int userId, @PathVariable("idFoto") String fotoId) {
        System.out.println("delete"+fotoId);
        return "redirect:/id{id}";
    }


}
