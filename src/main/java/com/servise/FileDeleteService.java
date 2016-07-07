package com.servise;

import java.io.IOException;

public interface FileDeleteService {

    void deleteFile(String absolutePath) throws IOException;

}
