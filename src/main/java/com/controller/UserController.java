package com.controller;

import com.entity.*;
import com.repository.FrendsRepository;
import com.repository.UserRepository;
import com.servise.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FrendsService frendsService;

    @Autowired
    FileSaveService fileSaveService;

    @Autowired
    AvatarPhotoService avatarPhotoService;

    @Autowired
    AlbomFotoService albomFotoUseService;


    @RequestMapping("/MainPage")
    public String ShowMainPage(Model model, Principal principal){
        if (principal != null){
            return "redirect:/id" + principal.getName();
        }
        return "redirect:/";
    }


    @RequestMapping("/id{id}")
    public String ShowMainPageForRoler (@PathVariable int id, Model model, Principal principal) {
        User owner = userRepository.findOne(id);
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
        System.out.println(idFoto);
        List<User> users = new ArrayList<User>();
        int indexLike = avatarPhotoService.findOne(idFoto).getUsersLikePhoto().size();
        int indexDisLike = avatarPhotoService.findOne(idFoto).getUsersDisLikePhoto().size();
        AvatarPhoto avatarPhoto = avatarPhotoService.findOne(idFoto);
        if (whote.equals("Like")){
            int startIndex = 0;
            for (User user: avatarPhotoService.findOne(idFoto).getUsersLikePhoto()) {
                if (startIndex <= indexLike - 1) {
                    users.add(startIndex, user);
                    startIndex++;
                }
            }
            users.add(startIndex,userRepository.findUserById(Integer.parseInt(principal.getName())));
            avatarPhoto.setCountLike(avatarPhoto.getCountLike()+1);
            avatarPhoto.setUsersLikePhoto(users);
            avatarPhotoService.save(avatarPhoto);
            return Integer.toString(avatarPhoto.getCountLike());
        }else
        if (whote.equals("DisLike")){
            int startIndex = 0;
            for (User user: avatarPhotoService.findOne(idFoto).getUsersDisLikePhoto()) {
                if (startIndex <= indexLike - 1) {
                    users.add(startIndex, user);
                    startIndex++;
                }
            }
            users.add(indexDisLike,userService.findById(Integer.parseInt(principal.getName())));
            avatarPhoto.setCountDisLike(avatarPhoto.getCountDisLike()+1);
            avatarPhoto.setUsersDisLikePhoto(users);
            avatarPhotoService.save(avatarPhoto);
            return Integer.toString(avatarPhoto.getCountDisLike());
        }
        return "";
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

    @RequestMapping("/photoUserPutLike-foto-{idPhoto}")
    @ResponseBody
    public List<String> photoUserPutLike(@PathVariable("idPhoto") int idFoto){
        List<String> list = new ArrayList<String>();
        for (User user: avatarPhotoService.findOne(idFoto).getUsersLikePhoto()){
            list.add(user.getFirstName());
        }
        return list;
    }

}
