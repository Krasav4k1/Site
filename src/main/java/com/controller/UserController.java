package com.controller;

import com.entity.User;
import com.servise.AlbomFotoService;
import com.servise.AvatarPhotoService;
import com.servise.FrendsService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Queue;

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
    public String[] moveAvatarPhoto(@PathVariable("index") int index, @PathVariable("id") int id,@PathVariable("control") String control){
       return userService.moveAvatarPhoto(index,id,control);
    }


    @RequestMapping("/add{whote}ForPhoto{idFoto}/user-{idUser}")
    @ResponseBody
    public String aadlikeFoto(@PathVariable("idFoto") int idFoto,@PathVariable("idUser") int idUser,@PathVariable("whote") String whote,Principal principal ){
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
    public @ResponseBody Queue<User> photoUserPutLike(@PathVariable("idPhoto") int idFoto){
        return userService.photoUserPutLike(idFoto);
    }

    @Transactional
    @RequestMapping(value = "/photoUserPutDisLike-foto-{idPhoto}.json")
    public @ResponseBody Queue<User> photoUserPutDisLike(@PathVariable("idPhoto") int idFoto){
        return userService.photoUserPutDisLike(idFoto);
    }



}
