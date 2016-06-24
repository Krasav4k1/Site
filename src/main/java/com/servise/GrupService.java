package com.servise;

import com.entity.Grup;
import com.entity.User;

public interface GrupService {

    void addGrupForUser(Grup grup, User user);

    Grup findById(int id);

}
