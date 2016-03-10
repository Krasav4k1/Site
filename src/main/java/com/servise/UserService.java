package com.servise;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private int idLoginUser;
    public Map<String, String> mapUser = new HashMap<String, String>();

    public void infoForUser(){
        for (int d = 1; d <= userRepository.count();d++) {
            if (idLoginUser == userRepository.findOne(d).getId()){
                mapUser.put("firstName", userRepository.findOne(d).getFirstName());
                mapUser.put("lastName", userRepository.findOne(d).getLastName());
            }
        }
    }

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
               idLoginUser = userRepository.findOne(d).getId();
               System.out.println(idLoginUser);
               infoForUser();
               return true;
           }
        }
        return false;
    }

}
