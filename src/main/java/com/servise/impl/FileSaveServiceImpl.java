package com.servise.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Service
public class FileSaveServiceImpl implements com.servise.FileSaveService {

    public String saveFile (String dir, String userId, MultipartFile file, String absolutePath, String id) throws IOException {
        File uploadRootDir = null;
        String originalName = null;
        String format = null;
        if(dir.equals("foto")){
            uploadRootDir = new File(absolutePath+File.separator+"uplodateFile"+File.separator+userId+File.separator+"foto"+File.separator+"albom-"+id);
            format = null;
            if (!uploadRootDir.exists()){
                uploadRootDir.mkdirs();
            }
            if (file.getOriginalFilename().endsWith(".jpg")){
                originalName = file.getOriginalFilename().replaceAll(".jpg","user");
                format = "jpg";
            }
            if (file.getOriginalFilename().endsWith(".png")){
                originalName = file.getOriginalFilename().replaceAll(".png","user");
                format = "png";
            }
        }
        BufferedImage bi =  ImageIO.read(new ByteArrayInputStream(file.getBytes()));
        File path = new File(uploadRootDir+File.separator+originalName+String.valueOf(userId)+"."+format);
        ImageIO.write(bi,format,path);
        return String.valueOf(path.getPath());

    }


}
