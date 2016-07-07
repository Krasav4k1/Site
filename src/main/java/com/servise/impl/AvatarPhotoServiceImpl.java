package com.servise.impl;

import com.entity.AvatarPhoto;
import com.entity.User;
import com.repository.AvatarPhotoRepository;
import com.servise.AvatarPhotoService;
import com.servise.FileDeleteService;
import com.servise.FileSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AvatarPhotoServiceImpl implements AvatarPhotoService {

    @Autowired
    AvatarPhotoRepository avatarPhotoRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    FileDeleteService deleteService;
    @Autowired
    FileSaveService fileSaveService;

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


    @Transactional
    public AvatarPhoto findOne(int id) {
        return avatarPhotoRepository.findOne(id);
    }

    public AvatarPhoto findOneById(int id){
        return avatarPhotoRepository.findBYIdPhoto(id);
    }

    public String addLikeAndDisLike(int idFoto, int idUser, String whote, Principal principal) {
        AvatarPhoto avatarPhoto = findOne(idFoto);
        if (whote.equals("Like")) {
            List<User> userLikePhoto = findOne(idFoto).getUsersLikePhoto();
            userLikePhoto.add(userService.findById(Integer.parseInt(principal.getName())));
            avatarPhoto.setUsersLikePhoto(userLikePhoto);
            avatarPhoto.setCountLike(avatarPhoto.getCountLike() + 1);
            save(avatarPhoto);
            return Integer.toString(avatarPhoto.getCountLike());
        } else if (whote.equals("DisLike")) {
            List<User> userDisLikePhoto = findOne(idFoto).getUsersDisLikePhoto();
            userDisLikePhoto.add(userService.findById(Integer.parseInt(principal.getName())));
            avatarPhoto.setCountDisLike(avatarPhoto.getCountDisLike() + 1);
            avatarPhoto.setUsersDisLikePhoto(userDisLikePhoto);
            save(avatarPhoto);
            return Integer.toString(avatarPhoto.getCountDisLike());
        }
        return "0";
    }

    public void daleteFileAvatarPhoto(int userId, String fotoId, HttpServletRequest request) throws IOException {
        String photoUser = userService.findById(userId).getFoto();
        String photoAva = findOne(Integer.parseInt(fotoId)).getFoto();
        if (photoUser.equals(photoAva)){
            deleteService.deleteFile(request.getServletContext().getRealPath("resources") + findOne(Integer.parseInt(fotoId)).getFoto().replaceAll("/resources",""));
            daletePhotoByPhotoId(Integer.parseInt(fotoId));
            if (getAllByIdUser(userId).size() == 0){
                User user = userService.findById(userId);
                user.setFoto("/resources/allForSite/default/defaultFoto.png");
                userService.editUser(user);
                AvatarPhoto avatarPhoto= getByIdUser(userId);
                avatarPhoto.setFoto("/resources/allForSite/default/defaultFoto.png");
                save(avatarPhoto);
            }else{
                User user = userService.findById(userId);
                user.setFoto(getAllByIdUser(userId).iterator().next().getFoto());
                userService.editUser(user);
            }
        }else {
            deleteService.deleteFile(request.getServletContext().getRealPath("resources") + findOne(Integer.parseInt(fotoId)).getFoto().replaceAll("/resources",""));
            daletePhotoByPhotoId(Integer.parseInt(fotoId));
        }
    }

    public int auditAvatarPhotoFile(MultipartFile file, HttpServletRequest request, Principal principal) throws IOException {
        if(file.getBytes().length >= 10000000){
            return 1;
        }else {
            String fotoPath = fileSaveService.saveFile("foto",principal.getName(), file, request.getServletContext().getRealPath("resources") ,"avatar");
            addFoto(fotoPath, Integer.parseInt(principal.getName()));
        }
        return 0;
    }
}
