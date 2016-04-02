package com.servise;

import com.entity.Grup;
import com.entity.User;
import com.repository.GrupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrupService {

    @Autowired
    GrupRepository grupRepository;

    public void addGrupForUser(Grup grup, User user){
        List<User> list = new ArrayList<User>();
        list.add(0,user);
        grup.setUsers(list);
        grupRepository.save(grup);
    }

    public Grup findById(int id) {
        return grupRepository.findOne(id);
    }
}
