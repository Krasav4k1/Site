package com.servise;

import com.entity.AlbomFotoUser;
import com.entity.AvatarPhoto;
import com.entity.Foto;
import com.repository.AvatarPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class AvatarPhotoService {

    @Autowired
    AvatarPhotoRepository avatarPhotoRepository;
    @Autowired
    UserService userService;

    public void save(AvatarPhoto avatarPhoto){
        avatarPhotoRepository.save(avatarPhoto);
    }


    public void addFoto(String foto, Principal principal) {
        Iterable<AvatarPhoto> avatarPhoto = avatarPhotoRepository.findAlbomByAlbomNameAndPrincipal(Integer.parseInt(principal.getName()));
        if (avatarPhoto.iterator().next().getFoto().equals("/resources/allForSite/default/defaultFoto.png")) {
            AvatarPhoto f = userService.findById(Integer.parseInt(principal.getName())).getAvatarPhotos().get(0);
            f.setUser(userService.findById(Integer.parseInt(principal.getName())));
            f.setFoto(foto);
            avatarPhotoRepository.save(f);
        }else{
            AvatarPhoto f = new AvatarPhoto();
            f.setUser(userService.findById(Integer.parseInt(principal.getName())));
            f.setFoto(foto);
            avatarPhotoRepository.save(f);
        }
    }

    public Iterable<AvatarPhoto> getAllByIdUser(int id) {
        return avatarPhotoRepository.findAllByIdUser(id);
    }
}
