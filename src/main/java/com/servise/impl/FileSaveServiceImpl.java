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
        String originalName = file.getOriginalFilename().toLowerCase();
        String format = null;
        if(dir.equals("foto")){
            uploadRootDir = new File(absolutePath+File.separator+"uplodateFile"+File.separator+userId+File.separator+"foto"+File.separator+"albom-"+id);
            if (!uploadRootDir.exists()){
                uploadRootDir.mkdirs();
            }
            if (originalName.endsWith(".jpg")){
                originalName = originalName.replaceAll(".jpg","user");
                format = "jpg";
            }
            if (originalName.endsWith(".jpeg")){
                originalName = originalName.replaceAll(".jpeg","user");
                format = "jpeg";
            }
            if (originalName.endsWith(".png")){
                originalName = originalName.replaceAll(".png","user");
                format = "png";
            }
        }
        BufferedImage bi =  ImageIO.read(new ByteArrayInputStream(file.getBytes()));
        File path = new File(uploadRootDir+File.separator+originalName+String.valueOf(userId)+"."+format);
        ImageIO.write(bi,format,path);
        return String.valueOf(path.getPath().replaceAll(absolutePath,"/resources").replace("\\","/"));
    }


}
