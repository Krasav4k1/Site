package com.servise;

import com.entity.Foto;

import java.security.Principal;

public interface FotoService {

    void addFoto(String foto,String fotoAlbomName, Principal principal);

    Iterable<Foto> getAllFotoPrincipal(int id);

    void save(Foto foto);

}
