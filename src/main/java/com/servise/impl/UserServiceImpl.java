package com.servise.impl;

import com.controller.CityController;
import com.entity.*;
import com.repository.UserRepository;
import com.servise.AlbomFotoService;
import com.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;
    @Autowired
    CityController cityController;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AlbomFotoService albomFotoServiceImpl;
    @Autowired
    FotoServiceImpl fotoService;
    @Autowired
    CityServiceImpl cityService;



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
        albomFotoServiceImpl.save(albomFotoUser);
        foto.setAlbomFotoUser(albomFotoUser);
        foto.setFoto("/resources/allForSite/default/defaultFoto.png");
        fotoService.save(foto);
    }


}
