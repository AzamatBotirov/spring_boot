package com.salom.vasalim.web.rest;
import java.io.*;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.salom.vasalim.model.ApplicationProperties;
import com.salom.vasalim.service.DTO.FileRoodDTO;
import com.salom.vasalim.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/file-reader")

public class FileResource {
    private final FileService fileService;
    private final ApplicationProperties properties;

    @GetMapping("/ls/root")
    public ResponseEntity<FileRoodDTO> getRootFolders() {
        List<String> result = properties.getFolders();
        return ResponseEntity.ok(new FileRoodDTO(Collections.emptyList(), result));
    }

    @GetMapping(value = "/ls", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getFiles(
            @RequestParam(name = "headPath") String headPath,
            @RequestParam(name = "curLocation") String curLocation
    ) {
        log.debug("Request to get all files and directories in folder: {}", properties.getFolders().get(0));

        return ResponseEntity.ok(fileService.getAsList(headPath, curLocation));
    }

    @RequestMapping("/file/download/")
    public void downloadPDFResource(
            HttpServletResponse response,
            @RequestParam(name = "headPath") String headPath,
            @RequestParam(name = "curLocation") String curLocation,
            @RequestParam(name = "fileName") String fileName
    )
            throws IOException {
        if (fileName == null || fileName.isEmpty()) {
            throw new IOException("Invalid params : fileName='" + fileName + "'");
        }

        boolean allowed = false;

        List<String> folderFiles = fileService.getAsListBase(headPath, curLocation);
        for (String folder : folderFiles) {
            if (fileName.startsWith(folder)) {
                allowed = true;
                break;
            }
        }

        if (!allowed) {
            throw new IOException("Permission denied : file '" + fileName + "'");
        }

        File file = new File(headPath + curLocation + fileName);
        if (file.exists()) {
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } else {
            throw new FileNotFoundException();
        }
    }

    public void downloadPDFResource(HttpServletResponse httpServletResponse, String testFileName) {}
}
