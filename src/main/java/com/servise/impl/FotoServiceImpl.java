package com.servise.impl;

import com.entity.AlbomFotoUser;
import com.entity.Foto;
import com.repository.AlbomFotoUserRepository;
import com.repository.FotoRepository;
import com.servise.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class FotoServiceImpl implements FotoService{

    @Autowired
    FotoRepository fotoRepository;
    @Autowired
    AlbomFotoUserRepository albomFotoUserRepository;

    public void addFoto(String foto,String fotoAlbomName, Principal principal){
        AlbomFotoUser albomFotoUser = albomFotoUserRepository.findAlbomByAlbomNameAndPrincipal(fotoAlbomName,Integer.parseInt(principal.getName()));
        if (fotoRepository.getDefaultFoto("/resources/allForSite/default/defaultFoto.png", albomFotoUser.getId()) != null) {
            Foto f = albomFotoUser.getFotos().iterator().next();
            f.setAlbomFotoUser(albomFotoUser);
            f.setFoto(foto);
            fotoRepository.save(f);
        }else{
            Foto f = new Foto();
            f.setAlbomFotoUser(albomFotoUser);
            f.setFoto(foto);
            fotoRepository.save(f);
        }
    }

      public Iterable<Foto> getAllFotoPrincipal(int id){
      return  fotoRepository.getAllFotoFromAlbom(id);
    }


    public void save(Foto foto) {
        fotoRepository.save(foto);
    }
}
