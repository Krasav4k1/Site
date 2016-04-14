package com.servise;

import com.entity.AlbomFotoUser;
import com.entity.Foto;
import com.repository.AlbomFotoUserRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlbomFotoService {

    @Autowired
    AlbomFotoUserRepository albomFotoUserRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FileDeleteService fileDeleteService;


    public void addAlbomFotoForUser(int id,AlbomFotoUser albomFotoUser){
        AlbomFotoUser al = albomFotoUser;
        List<Foto> f = new ArrayList<Foto>();
        Foto foto = new Foto();
        al.setUser(userRepository.findOne(id));
        foto.setAlbomFotoUser(al);
        foto.setFoto("/resources/allForSite/default/defaultFoto.png");
        f.add(0,foto);
        al.setFotos(f);
        albomFotoUserRepository.save(al);
    }

    public Iterable<AlbomFotoUser> getAllAlbomPrincipal(int id){
        return albomFotoUserRepository.getAllAlbomFotoByUserId(id);
    }

    public String getNameAlbom(int id){
        return albomFotoUserRepository.findOne(id).getAlbomName();
    }

    public void removeByid(int id, Principal principal) throws IOException {
        AlbomFotoUser albomFotoUser = albomFotoUserRepository.findOne(id);
        fileDeleteService.deleteFile("C:\\Users\\Andrii\\EclipseProject\\gfgf\\src\\main\\webapp\\resources\\uplodateFile\\" + principal.getName() + "\\foto" + "\\albom-"+albomFotoUser.getAlbomName());
        fileDeleteService.deleteFile("C:\\Program Files\\apache-tomcat-8.0.32\\webapps\\ROOT\\resources\\uplodateFile\\" + principal.getName() + "\\foto" + "\\albom-"+albomFotoUser.getAlbomName());
        fileDeleteService.deleteFile("C:\\Users\\Andrii\\EclipseProject\\gfgf\\target\\gfgf-0.0.1-SNAPSHOT\\resources\\uplodateFile\\" + principal.getName() + "\\foto" + "\\albom-"+albomFotoUser.getAlbomName());
        albomFotoUser.setUser(null);
        albomFotoUser.setGrup(null);
        albomFotoUser.setFotos(null);
        albomFotoUserRepository.delete(albomFotoUser);
        albomFotoUserRepository.delete(albomFotoUser.getId());
    }

    public void save(AlbomFotoUser albomFotoUser) {
        albomFotoUserRepository.save(albomFotoUser);
    }
}
