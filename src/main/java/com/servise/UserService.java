package com.servise;

import com.entity.AvatarPhoto;
import com.entity.User;

import java.util.List;
import java.util.Queue;

public interface UserService {

    void updateUser(int id);

    Iterable<User> getAll();

    void dalete(String id);

    void save(User user);

    List<AvatarPhoto> addAvatarDefault(User user);

    User findById(int id);

    User editUser(User user);

    void addFotoAlbomDefauld(User user);

    String[] moveAvatarPhoto(int index, int id, String control);

    Queue<User> photoUserPutLike(int idFoto);

    Queue<User> photoUserPutDisLike(int idFoto);
}
