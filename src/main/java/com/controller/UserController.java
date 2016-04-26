package com.controller;

import com.entity.*;
import com.servise.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
@Transactional
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    FrendsService frendsService;

    @Autowired
    AvatarPhotoService avatarPhotoService;

    @Autowired
    AlbomFotoService albomFotoUseService;


    @RequestMapping("/MainPage")
    public String ShowMainPage(Model model, Principal principal){
        if (principal != null) {
            return "redirect:/id" + principal.getName();
        }

        return "redirect:/";
    }


    @RequestMapping("/id{id}")
    public String ShowMainPageForRoler (@PathVariable int id, Model model, Principal principal) {
        User owner = userService.findById(id);
        if ( owner == null ){
            return "NonUser";
        }
        userService.updateUser(id);
        model.addAttribute("user", owner);
        model.addAttribute("avatarPhoto", avatarPhotoService.getAllByIdUser(id));
        model.addAttribute("caruselPhoto", albomFotoUseService.getCaruselByPrincipal("фотослайдер",id));
        if (principal != null) {
            auditOnFrenship(principal, owner, model);
        }
        return "MainPage";
    }

    private void auditOnFrenship(Principal principal, User user, Model model) {
        if (frendsService.findRecivedAndSend(user.getId(),Integer.parseInt(principal.getName())) != null){
            model.addAttribute("friendsPresent", true);
        }else if(frendsService.findRecivedAndSend(Integer.parseInt(principal.getName()),user.getId()) != null){
            model.addAttribute("friendsPresent", true);
        }

    }

    @RequestMapping(value = "/getFoto/user={id}/foto={index}/{control}")
    @ResponseBody
    public String[] testMethod(@PathVariable("index") int index, @PathVariable("id") int id,@PathVariable("control") String control){
        ArrayList<AvatarPhoto> list = avatarPhotoService.getAllByIdUser(id);
        String[] arg = new String[3];
        if(control.equals("right")) {
            index++;
            if (index >= list.size()) {
                index = 0;
            }
        }
        if (control.equals("left")) {
            index--;
            if (index < 0) {
                index = list.size()-1;
            }
        }
        if (list.get(index) != null) {
            arg[0] = list.get(index).getFoto();
            arg[1] = Integer.toString(list.size());
            arg[2] = Integer.toString(list.get(index).getId());
            return arg;
        }

        return arg;
    }


    @RequestMapping("/add{whote}ForPhoto{idFoto}/user-{idUser}")
    @ResponseBody
    public String aadlikeFoto(@PathVariable("idFoto") int idFoto,@PathVariable("idUser") int idUser,@PathVariable("whote") String whote,Principal principal){
        return avatarPhotoService.addLikeAndDisLike(idFoto,idUser,whote,principal);
    }

    @RequestMapping("/likeForFoto={idFoto}")
    @ResponseBody
    public String likeFoto(@PathVariable("idFoto") int idFoto){
        return Integer.toString(avatarPhotoService.findOne(idFoto).getCountLike());
    }

    @RequestMapping("/disLikeForFoto={idFoto}")
    @ResponseBody
    public String disLikeFoto(@PathVariable("idFoto") int idFoto){
        return Integer.toString(avatarPhotoService.findOne(idFoto).getCountDisLike());
    }

    @RequestMapping("/countPhoto-user-{idUser}")
    @ResponseBody
    public String countFoto(@PathVariable("idUser") int idUser){
        return Integer.toString(avatarPhotoService.getAllByIdUser(idUser).size());
    }

    @Transactional
    @RequestMapping(value = "/photoUserPutLike-foto-{idPhoto}.json")
    public @ResponseBody List<User> photoUserPutLike(@PathVariable("idPhoto") int idFoto){
            Hibernate.initialize(avatarPhotoService.findOneById(idFoto).getUsersLikePhoto());
        return avatarPhotoService.findOneById(idFoto).getUsersLikePhoto();
    }

    @Transactional
    @RequestMapping("/photoUserPutDisLike-foto-{idPhoto}.json")
    public @ResponseBody List<User> photoUserPutDisLike(@PathVariable("idPhoto") int idFoto){
        Hibernate.initialize(avatarPhotoService.findOneById(idFoto).getUsersDisLikePhoto());
        return avatarPhotoService.findOneById(idFoto).getUsersDisLikePhoto();
    }



}
