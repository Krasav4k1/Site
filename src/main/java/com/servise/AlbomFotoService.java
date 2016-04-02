package com.servise;

import com.entity.AlbomFotoUser;
import com.repository.AlbomFotoUserRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class AlbomFotoService {

    @Autowired
    AlbomFotoUserRepository albomFotoUserRepository;
    @Autowired
    UserRepository userRepository;


    public void addAlbomFotoForUser(int id,AlbomFotoUser albomFotoUser){
        AlbomFotoUser al = albomFotoUser;
        al.setUser(userRepository.findOne(id));
        albomFotoUserRepository.save(al);
    }

    public Iterable<AlbomFotoUser> getAllAlbomPrincipal(int id){
        return albomFotoUserRepository.getAllAlbomFotoByUserId(id);
    }

}
