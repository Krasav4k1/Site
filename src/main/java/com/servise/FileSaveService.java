package com.servise;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileSaveService {

    String saveFile(String dir, String userId, MultipartFile file, String absolutePath, String id) throws IOException;


}
