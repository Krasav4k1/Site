package com.servise;

import com.entity.AvatarPhoto;
import com.entity.User;

import java.util.List;

public interface UserService {

    void updateUser(int id);

    Iterable<User> getAll();

    void dalete(String id);

    void save(User user);

    List<AvatarPhoto> addAvatarDefault(User user);

    User findById(int id);

    User editUser(User user);

    void addFotoAlbomDefauld(User user);
}
