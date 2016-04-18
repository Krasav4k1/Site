package com.controller;

import com.entity.AvatarPhoto;
import com.entity.User;
import com.servise.AvatarPhotoService;
import com.servise.FileDeleteService;
import com.servise.FileSaveService;
import com.servise.UserService;
import org.mortbay.servlet.MultiPartFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
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
        if( file.getBytes().length >= 10000000){
            return "Завеликий файл";
        }else {
            String absolutePath1 = request.getServletContext().getRealPath("resources");
            String absolutePath2 = "C:\\Users\\Andrii\\EclipseProject\\gfgf\\src\\main\\webapp\\resources";
            String albomeName = "avatar";
            String fotoPath = fileSaveService.saveFile("foto",principal.getName(), file, absolutePath1,albomeName);
            fileSaveService.saveFile("foto",principal.getName(), file, absolutePath2,albomeName);
            avatarPhotoService.addFoto(fotoPath.substring(50), Integer.parseInt(principal.getName()));
            System.out.println(absolutePath1);
        }
        return "redirect:/id{id}";
    }

    @RequestMapping("/id{id}/deleFileAvatarFoto{idFoto}")
    public String deleFileAvatarFoto(@PathVariable("id") int userId, @PathVariable("idFoto") String fotoId, HttpServletRequest request) throws IOException {
        String photoUser = userService.findById(userId).getFoto();
        String photoAva = avatarPhotoService.findOne(Integer.parseInt(fotoId)).getFoto();
        if (photoUser.equals(photoAva)){
            deleteService.deleteFile(request.getServletContext().getRealPath("resources") + avatarPhotoService.findOne(Integer.parseInt(fotoId)).getFoto().substring(10));
            deleteService.deleteFile("C:\\Users\\Andrii\\EclipseProject\\gfgf\\src\\main\\webapp" + avatarPhotoService.findOne(Integer.parseInt(fotoId)).getFoto());
            deleteService.deleteFile("C:\\Users\\Andrii\\EclipseProject\\gfgf\\target\\gfgf-0.0.1-SNAPSHOT\\" + avatarPhotoService.findOne(Integer.parseInt(fotoId)).getFoto());
            avatarPhotoService.daletePhotoByPhotoId(Integer.parseInt(fotoId));
            if (avatarPhotoService.getAllByIdUser(userId).size() == 0){
                User user = userService.findById(userId);
                user.setFoto("/resources/allForSite/default/defaultFoto.png");
                userService.editUser(user);
                AvatarPhoto avatarPhoto= avatarPhotoService.getByIdUser(userId);
                avatarPhoto.setFoto("/resources/allForSite/default/defaultFoto.png");
                avatarPhotoService.save(avatarPhoto);
            }else{
                User user = userService.findById(userId);
                user.setFoto(avatarPhotoService.getAllByIdUser(userId).iterator().next().getFoto());
                userService.editUser(user);
            }
        }else {
            deleteService.deleteFile(request.getServletContext().getRealPath("resources") + avatarPhotoService.findOne(Integer.parseInt(fotoId)).getFoto().substring(10));
            deleteService.deleteFile("C:\\Users\\Andrii\\EclipseProject\\gfgf\\src\\main\\webapp" + avatarPhotoService.findOne(Integer.parseInt(fotoId)).getFoto());
            deleteService.deleteFile("C:\\Users\\Andrii\\EclipseProject\\gfgf\\target\\gfgf-0.0.1-SNAPSHOT\\" + avatarPhotoService.findOne(Integer.parseInt(fotoId)).getFoto());
            avatarPhotoService.daletePhotoByPhotoId(Integer.parseInt(fotoId));
        }
        return "redirect:/id{id}";
    }


}
