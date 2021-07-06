package com.salom.vasalim.service;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.salom.vasalim.model.ApplicationProperties;
import com.salom.vasalim.service.DTO.FileInfoDTO;
import com.salom.vasalim.service.DTO.FileReaderDTO;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class FileService {
    private final ApplicationProperties properties;

    public FileService(ApplicationProperties properties) {
        this.properties = properties;
    }

    public FileReaderDTO getAsList(String headPath, String curLocation) {
        try {
            var path = headPath + curLocation;

            boolean isDir = Files.isDirectory(Paths.get(path));
            if (isDir) {
                System.out.println("File is a Directory");
            } else {
                System.out.println("Directory doesn't exist!!");
            }
            List<FileInfoDTO> files = new ArrayList<>();
            List<String> directories = new ArrayList<>();
            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    files.add(new FileInfoDTO(listOfFile.getName(), listOfFile.getPath()));
                } else if (listOfFile.isDirectory()) {
                    directories.add(listOfFile.getName());
                }
            }
            FileReaderDTO fileReaderDTO = new FileReaderDTO();
            fileReaderDTO.setHeadPath(headPath);
            fileReaderDTO.setCurLocation(curLocation);
            fileReaderDTO.setDirectories(directories);
            fileReaderDTO.setFiles(files);

            return fileReaderDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<String> getAsListBase(String headPath, String curLocation) {
        String path = headPath + curLocation;
        try {
            File parentDir = new File(path);
            return Arrays.asList(parentDir.list());
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
