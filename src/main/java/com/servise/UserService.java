package com.servise;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean comparisonUser(String password, String Email) {
        for (int d = 1; d <= userRepository.count();d++) {
           if(userRepository.findOne(d).getEmail().equals(Email) && userRepository.findOne(d).getPassword().equals(password)){
               return true;
           }
        }
        return false;

    }

}
