package com.example.demo.utils;

import java.io.IOException;

public interface FileUtil {
    String readFileContent(String filepath) throws IOException;

    void write(String content, String filepath) throws IOException;
}
