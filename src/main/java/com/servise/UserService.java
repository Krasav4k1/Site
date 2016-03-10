package com.servise;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(String lastName, String firstName, String password, String emailUser){
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPassword(password);
        user.setEmail(emailUser);
        userRepository.save(user);
        System.out.println(user.getFirstName());
    }

}
