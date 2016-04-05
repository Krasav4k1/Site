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
        user.setAlbomFotoUsers(addFotoAlbomDefauld(user));
        userRepository.save(user);
    }


    public User findById(int id) {
        return userRepository.findOne(id);
    }

    public User editUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<AlbomFotoUser> addFotoAlbomDefauld(User user) {
        List<AlbomFotoUser> list = new ArrayList<AlbomFotoUser>();
        AlbomFotoUser albomFotoUser = new AlbomFotoUser();
        albomFotoUser.setAlbomName("carusel");
        albomFotoUser.setUser(user);
        list.add(albomFotoUser);
        return list;
    }


}
