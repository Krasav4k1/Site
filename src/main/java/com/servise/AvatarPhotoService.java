package com.servise;

import com.entity.AvatarPhoto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

public interface AvatarPhotoService {

    void save(AvatarPhoto avatarPhoto);

    void addFoto(String foto, int id);

    ArrayList<AvatarPhoto> getAllByIdUser(int id);

    AvatarPhoto getByIdUser(int id);

    void daletePhotoByPhotoId(int fotoId);

    AvatarPhoto findOne(int id);

    AvatarPhoto findOneById(int id);

    String addLikeAndDisLike(int idFoto, int idUser, String whote, Principal principal);

    void daleteFileAvatarPhoto(int userId, String fotoId, HttpServletRequest request) throws IOException;

    int auditAvatarPhotoFile(MultipartFile file, HttpServletRequest request, Principal principal) throws IOException;
}
