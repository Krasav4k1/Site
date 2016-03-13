package com.servise;

import com.entity.*;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private int idForUserLogin;
    public Map<String, String> mapUser = new HashMap<String, String>();

    //Метод додавання юзерів
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

    //UpdateUser
    public void updateUser(String Email, String password){
        User user1 ;
        user1 = userRepository.findUserByEmailAndPassword(Email, password);
        userRepository.save(user1);
    }

    //Search for visit people
    public void comparisonUserVisit(int id){
            SearchInfo(userRepository.findUserById(id).getId());
    }

    //Search for login user
    public int comparisonUser(String password, String Email) {
       return SearchInfo(userRepository.findUserByEmailAndPassword(Email, password).getId());
    }

    //Метод перевірки на наявність емайла і пароля і заповнення мапи
    public int SearchInfo(int idForUserLogin) {
        try {
            if (userRepository.findOne(idForUserLogin).getStatys() == 0) {
                mapUser.put("firstName", userRepository.findOne(idForUserLogin).getFirstName());
                mapUser.put("lastName", userRepository.findOne(idForUserLogin).getLastName());
                try {
                    mapUser.put("age", Integer.toString(userRepository.findOne(idForUserLogin).getAge()));
                    mapUser.put("day", Integer.toString(userRepository.findOne(idForUserLogin).getDay()));
                    mapUser.put("mouth", Integer.toString(userRepository.findOne(idForUserLogin).getMouth()));
                    mapUser.put("year", Integer.toString(userRepository.findOne(idForUserLogin).getYear()));
                    mapUser.put("city", userRepository.findOne(idForUserLogin).getCity().getName());
                    mapUser.put("region", userRepository.findOne(idForUserLogin).getCity().getRagion().getName());
                    mapUser.put("oblast", userRepository.findOne(idForUserLogin).getCity().getRagion().getOblast().getName());
                    mapUser.put("country", userRepository.findOne(idForUserLogin).getCity().getRagion().getOblast().getCountry().getName());
                } catch (NullPointerException e) {
                }
                return 0;
            } else if (userRepository.findOne(idForUserLogin).getStatys() == 1) {
                return 1;
            }
        } catch (NullPointerException e) {
            return 9;
        }
        return 9;
    }

    //Дістає все
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    //Видаляння
    public void dalete(String id) {
        userRepository.delete(Integer.parseInt(id));
    }
}
