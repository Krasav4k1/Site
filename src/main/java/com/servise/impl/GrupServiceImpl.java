package com.servise.impl;

import com.entity.Grup;
import com.entity.User;
import com.repository.GrupRepository;
import com.servise.GrupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupServiceImpl implements GrupService{

    @Autowired
    GrupRepository grupRepository;

    public void addGrupForUser(Grup grup, User user){
    }

    public Grup findById(int id) {
        return grupRepository.findOne(id);
    }
}
