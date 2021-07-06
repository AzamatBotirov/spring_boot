package com.salom.vasalim.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfoDTO {
    private String fileName;

    private String downloadUrl;
}
