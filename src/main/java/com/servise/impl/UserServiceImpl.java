package com.servise.impl;

import com.controller.CityController;
import com.entity.*;
import com.repository.UserRepository;
import com.servise.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;
    @Autowired
    CityController cityController;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AlbomFotoService albomFotoService;
    @Autowired
    FotoService fotoService;
    @Autowired
    CityService cityService;
    @Autowired
    AvatarPhotoService avatarPhotoService;

    //UpdateUser
    public void updateUser(int id){
        User user1 ;
        user1 = userRepository.findOne(id);

    }

    //Дістає все
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }


    //Видаляння
    public void dalete(String id) {
        userRepository.delete(Integer.parseInt(id));
    }



    public void save(User user) {
        user.setRole(Role.ROLE_USER);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCity(cityController.cityId);
        if (user.getCity() == null){
            user.setCity(cityService.findCity(5470084));
        }
        user.setFoto("/resources/allForSite/default/defaultFoto.png");
        user.setAvatarPhotos(addAvatarDefault(user));
        userRepository.save(user);
        addFotoAlbomDefauld(user);
    }

    public List<AvatarPhoto> addAvatarDefault(User user) {
        List<AvatarPhoto> list = new ArrayList<AvatarPhoto>();
        AvatarPhoto avatarPhoto = new AvatarPhoto();
        avatarPhoto.setFoto("/resources/allForSite/default/defaultFoto.png");
        avatarPhoto.setUser(user);
        list.add(avatarPhoto);
        return list;
    }


    public User findById(int id) {
        return userRepository.findOne(id);
    }

    public User editUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void addFotoAlbomDefauld(User user) {
        AlbomFotoUser albomFotoUser = new AlbomFotoUser();
        Foto foto = new Foto();
        albomFotoUser.setAlbomName("Фотослайдер");
        albomFotoUser.setUser(user);
        albomFotoService.save(albomFotoUser);
        foto.setAlbomFotoUser(albomFotoUser);
        foto.setFoto("/resources/allForSite/default/defaultFoto.png");
        fotoService.save(foto);
    }

    public String[] moveAvatarPhoto(int index, int id, String control) {
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

    public Queue<User> photoUserPutLike(int idFoto) {
        Queue<User> list = new ArrayDeque<User>();
        Hibernate.initialize(avatarPhotoService.findOneById(idFoto).getUsersLikePhoto());
        if (avatarPhotoService.findOneById(idFoto).getUsersLikePhoto().size() >= 8) {
            for (int d = 0; d < 8; d++) {
                list.add(avatarPhotoService.findOneById(idFoto).getUsersLikePhoto().get(d));
            }
            return list;
        }else{
            for (User user : avatarPhotoService.findOneById(idFoto).getUsersLikePhoto()) {
                list.add(user);
            }
            return list;
        }
    }

    public Queue<User> photoUserPutDisLike(int idFoto) {
        Queue<User> list = new ArrayDeque<User>();
        Hibernate.initialize(avatarPhotoService.findOneById(idFoto).getUsersDisLikePhoto());
        if (avatarPhotoService.findOneById(idFoto).getUsersLikePhoto().size() >= 8) {
            for (int d = 0; d < 8; d++) {
                list.add(avatarPhotoService.findOneById(idFoto).getUsersDisLikePhoto().get(d));
            }
            return list;
        }else{
            for (User user : avatarPhotoService.findOneById(idFoto).getUsersDisLikePhoto()) {
                list.add(user);
            }
            return list;
        }
    }


}
