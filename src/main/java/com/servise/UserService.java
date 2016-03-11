package com.servise;

import com.entity.*;
import com.repository.CityRepository;
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


    public void addUser(String lastName, String firstName, String password, String emailUser,int age, int day, int mouth,int year){
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPassword(password);
        user.setEmail(emailUser);
        user.setAge(age);
        user.setDay(day);
        user.setMouth(mouth);
        user.setYear(year);
        userRepository.save(user);
    }

    public boolean comparisonUser(String password, String Email) {
        for (int d = 1; d <= userRepository.count();d++) {
           if(userRepository.findOne(d).getEmail().equals(Email) && userRepository.findOne(d).getPassword().equals(password)){
               idLoginUser = userRepository.findOne(d).getId();
               System.out.println(idLoginUser);
               mapUser.put("firstName", userRepository.findOne(d).getFirstName());
               mapUser.put("lastName", userRepository.findOne(d).getLastName());
               mapUser.put("age", Integer.toString(userRepository.findOne(d).getAge()));
               mapUser.put("day", Integer.toString(userRepository.findOne(d).getDay()));
               mapUser.put("mouth", Integer.toString(userRepository.findOne(d).getMouth()));
               mapUser.put("year", Integer.toString(userRepository.findOne(d).getYear()));
               return true;
           }
        }
        return false;
    }


}
