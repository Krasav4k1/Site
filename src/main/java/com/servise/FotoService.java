package com.servise;

import com.entity.Foto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

public interface FotoService {

    void addFoto(String foto,String fotoAlbomName, Principal principal);

    Iterable<Foto> getAllFotoPrincipal(int id);

    void save(Foto foto);

    int auditAndAddFotoFile(MultipartFile file, HttpServletRequest request, Principal principal, int id) throws IOException;
}
