package com.servise;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.deleteDirectory;

@Service
public class FileDeleteService {

    public void deleteFile(String absolutePath) throws IOException {
        File dir = new File(absolutePath);
        deleteDirectory(dir);
    }

}
