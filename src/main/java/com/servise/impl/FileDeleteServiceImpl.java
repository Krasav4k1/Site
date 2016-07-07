package com.servise.impl;

import com.servise.FileDeleteService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

//import static org.apache.commons.io.FileUtils.deleteDirectory;
import static org.apache.tomcat.util.http.fileupload.FileUtils.deleteDirectory;
@Service

public class FileDeleteServiceImpl implements FileDeleteService {

    public void deleteFile(String absolutePath) throws IOException {
        File file = new File(absolutePath);
        if(file.isDirectory()) {
            deleteDirectory(file);
        }else{
            file.delete();
        }
    }

}
