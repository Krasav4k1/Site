package com.controller;

import com.entity.AvatarPhoto;
import com.servise.AvatarPhotoService;
import com.servise.FileDeleteService;
import com.servise.FileSaveService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Controller
@Transactional
public class AvatarPhotoController {

    @Autowired
    AvatarPhotoService avatarPhotoService;
    @Autowired
    FileSaveService fileSaveService;
    @Autowired
    FileDeleteService deleteService;
    @Autowired
    UserService userService;

    @ModelAttribute("avatarPhotoList")
    public Iterable<AvatarPhoto> getAllAvatarPhoto(Principal principal){
        return avatarPhotoService.getAllByIdUser(Integer.parseInt(principal.getName()));
    }

    @RequestMapping(value = "/id{id}/addFileAvatarFoto")
    public String addAvatarPhoto(@RequestParam("file") MultipartFile file,@PathVariable("id")int id, HttpServletRequest request, Principal principal) throws IOException{
       int rez = avatarPhotoService.auditAvatarPhotoFile(file,request,principal);
        if (rez == 1){
            return "файл завеликий";
        }
        return "redirect:/id{id}";
    }

    @RequestMapping("/id{id}/deleFileAvatarFoto{idFoto}")
    public String deleFileAvatarFoto(@PathVariable("id") int userId, @PathVariable("idFoto") String fotoId, HttpServletRequest request) throws IOException {
        avatarPhotoService.daleteFileAvatarPhoto(userId,fotoId,request);
        return "redirect:/id{id}";
    }


}
