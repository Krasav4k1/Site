package com.servise;

import com.controller.CityController;
import com.entity.*;
import com.repository.CityRepository;
import com.repository.CountryRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    //Prisipal

    @Autowired
    private UserRepository userRepository;
    @Autowired
    CityController cityController;
    @Autowired
    CityRepository  cityRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    private int idForUserLogin;
    public Map<String, String> mapUser = new HashMap<String, String>();

    //Метод додавання юзерів
    public void addUser(String lastName, String firstName, String password, String emailUser, int day, int mouth,int year){
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setEmail(emailUser);
        user.setDay(day);
        user.setMouth(mouth);
        user.setYear(year);
        user.setRole(Role.ROLE_USER);
        user.setCity(cityController.cityId);
        userRepository.save(user);
    }

    //UpdateUser
    public void updateUser(String Email, String password){
        User user1 ;
        user1 = userRepository.findUserByEmailAndPassword("Andriubliznuk@mail.ru", "Andriu1997");
        user1.setRole(Role.ROLE_ADMIN);
        userRepository.save(user1);
    }

    //Search for visit people
    public void comparisonUserVisit(int id){
        if(userRepository.findOne(id) != null){
            SearchInfo(userRepository.findUserById(id).getId());
        }
    }


    public void SearchInfo(int idForUserLogin) {
                mapUser.put("firstName", userRepository.findOne(idForUserLogin).getFirstName());
                mapUser.put("lastName", userRepository.findOne(idForUserLogin).getLastName());
                mapUser.put("age", Integer.toString(userRepository.findOne(idForUserLogin).getAge()));
                mapUser.put("day", Integer.toString(userRepository.findOne(idForUserLogin).getDay()));
                mapUser.put("mouth", Integer.toString(userRepository.findOne(idForUserLogin).getMouth()));
                mapUser.put("year", Integer.toString(userRepository.findOne(idForUserLogin).getYear()));
                mapUser.put("city", userRepository.findOne(idForUserLogin).getCity().getName());
                mapUser.put("region",userRepository.findOne(idForUserLogin).getCity().getRegion());
                mapUser.put("oblast",userRepository.findOne(idForUserLogin).getCity().getOblast());
                mapUser.put("country",userRepository.findOne(idForUserLogin).getCity().getCountry().getName());
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
