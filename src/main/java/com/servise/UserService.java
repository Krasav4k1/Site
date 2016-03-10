package com.servise;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(String lastName, String firstName, String password, String emailUser){
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPassword(password);
        user.setEmail(emailUser);
        userRepository.save(user);
    }
    public boolean auditUser(String email, String password){

        return false;
    }


}
