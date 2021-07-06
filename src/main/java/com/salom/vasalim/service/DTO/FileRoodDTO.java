package com.salom.vasalim.service.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRoodDTO {
    private List<String> files;

    private List<String> directories;
}
