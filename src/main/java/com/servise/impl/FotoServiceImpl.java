package com.servise.impl;

import com.entity.AlbomFotoUser;
import com.entity.Foto;
import com.repository.AlbomFotoUserRepository;
import com.repository.FotoRepository;
import com.servise.AlbomFotoService;
import com.servise.FileSaveService;
import com.servise.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
@Service

public class FotoServiceImpl implements FotoService{

    @Autowired
    FotoRepository fotoRepository;
    @Autowired
    AlbomFotoUserRepository albomFotoUserRepository;
    @Autowired
    FileSaveService fileSaveService;
    @Autowired
    AlbomFotoService albomFotoService;

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

    public int auditAndAddFotoFile(MultipartFile file, HttpServletRequest request, Principal principal, int id) throws IOException {
        if( file.getBytes().length >= 10000000){
            return 1;
        }else {
            String albomeName = albomFotoService.getNameAlbom(id);
            String fotoPath = fileSaveService.saveFile("foto",principal.getName(), file, request.getServletContext().getRealPath("resources"),albomeName);
            addFoto(fotoPath,albomeName, principal);
        }
        return 0;
    }
}
