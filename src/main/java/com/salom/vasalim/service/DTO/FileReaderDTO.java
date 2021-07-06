package com.salom.vasalim.service.DTO;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileReaderDTO {
    private String headPath;

    private String curLocation;

    private List<String> directories;

    private List<FileInfoDTO> files;
}
