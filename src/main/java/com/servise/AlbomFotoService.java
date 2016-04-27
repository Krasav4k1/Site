package com.servise;

import com.entity.AlbomFotoUser;

import java.io.IOException;
import java.security.Principal;


public interface AlbomFotoService {

    void addAlbomFotoForUser(int id,AlbomFotoUser albomFotoUser);

    Iterable<AlbomFotoUser> getAllAlbomPrincipal(int id);

    AlbomFotoUser getCaruselByPrincipal(String nameAlbom, int id);

    String getNameAlbom(int id);

    void removeByid(int id, Principal principal)  throws IOException;

    void save(AlbomFotoUser albomFotoUser);

    AlbomFotoUser findOneNameAlbom(String s);
}
