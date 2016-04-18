package com.servise;

import com.entity.AlbomFotoUser;
import com.entity.AvatarPhoto;
import com.entity.Foto;
import com.entity.User;
import com.repository.AvatarPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;

@Service
@Transactional
public class AvatarPhotoService {

    @Autowired
    AvatarPhotoRepository avatarPhotoRepository;
    @Autowired
    UserService userService;

    public void save(AvatarPhoto avatarPhoto){
        avatarPhotoRepository.save(avatarPhoto);
    }


    public void addFoto(String foto, int id) {
        Iterable<AvatarPhoto> avatarPhoto = avatarPhotoRepository.findAlbomByAlbomNameAndPrincipal(id);
        if (avatarPhoto.iterator().next().getFoto().equals("/resources/allForSite/default/defaultFoto.png")) {
            AvatarPhoto f = userService.findById(id).getAvatarPhotos().get(0);
            f.setUser(userService.findById(id));
            f.setFoto(foto);
            avatarPhotoRepository.save(f);
            User u = userService.findById(id);
            u.setFoto(foto);
            userService.editUser(u);
        }else{
            AvatarPhoto f = new AvatarPhoto();
            f.setUser(userService.findById(id));
            f.setFoto(foto);
            avatarPhotoRepository.save(f);
            User u = userService.findById(id);
            u.setFoto(foto);
            userService.editUser(u);
        }
    }

    public ArrayList<AvatarPhoto> getAllByIdUser(int id) {
        return avatarPhotoRepository.findAllByIdUser(id);
    }

    public AvatarPhoto getByIdUser(int id) {
        return avatarPhotoRepository.findByIdUser(id);
    }


    public void daletePhotoByPhotoId(int fotoId) {
        AvatarPhoto avatarPhoto = avatarPhotoRepository.findOne(fotoId);
        avatarPhoto.setUser(null);
        avatarPhoto.setUsersLikePhoto(null);
        avatarPhoto.setUsersDisLikePhoto(null);
        avatarPhoto.setUsersCommentPhoto(null);
        avatarPhotoRepository.delete(avatarPhoto);
    }

    public AvatarPhoto findOne(int id) {
        return avatarPhotoRepository.findOne(id);
    }
}
