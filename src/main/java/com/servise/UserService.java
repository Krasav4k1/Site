package com.servise;

import com.controller.CityController;
import com.entity.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserService {

    //Prisipal

    @Autowired
    UserRepository userRepository;
    @Autowired
    CityController cityController;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AlbomFotoService albomFotoService;
    @Autowired
    FotoService fotoService;


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
        user.setFoto("/resources/allForSite/default/defaultFoto.png");
        userRepository.save(user);
        addFotoAlbomDefauld(user);
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


}
