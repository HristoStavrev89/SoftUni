package com.softuni.springdataintroexercise.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FileUtilImpl implements FileUtil{

    @Override
    public String[] readFileContent(String filePath) throws IOException {
        File path = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Set<String> result = new LinkedHashSet<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!"".equals(line)) {
                result.add(line);
            }
        }
        return result.toArray(String[]::new);
        //Shorter version
//        return Files.readAllLines(Paths.get(path))
//                .stream()
//                .filter(x -> !x.isEmpty())
//                .collect(Collectors.toList());
    }
}
