package com.servise;

import com.entity.AlbomFotoUser;
import com.entity.Foto;
import com.repository.AlbomFotoUserRepository;
import com.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Service
public class FotoService {

    @Autowired
    FotoRepository fotoRepository;
    @Autowired
    AlbomFotoUserRepository albomFotoUserRepository;

    Principal principal;

    public void addFoto(String foto,String fotoAlbomName){
        Foto f = new Foto();
        AlbomFotoUser albomFotoUser = albomFotoUserRepository.findAlbomByAlbomNameAndPrincipal(fotoAlbomName,Integer.parseInt(principal.getName()));
        f.setAlbomFotoUser(albomFotoUser);
        f.setFoto(foto);
        fotoRepository.save(f);
    }

      public Iterable<Foto> getAllFotoPrincipal(Principal principal, int id){
      return  fotoRepository.getAllFotoFromAlbom(id);
    }


}
