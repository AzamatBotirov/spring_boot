package com.salom.vasalim.service;


import com.salom.vasalim.VasalimApplication;
import com.salom.vasalim.model.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = VasalimApplication.class)
@RunWith(SpringRunner.class)
public class FileServiceTest {

    @Autowired
    private FileService fileService;
    @Autowired
    private ApplicationProperties properties;


    @Test
    @Transactional
    public void getAsListMethodSuccessTest() {
        log.info("getAsListSuccessTest started");

        assertThat(properties.getFolders()).isNotNull();
        assertThat(properties.getFolders()).isNotEmpty();

      List<String> result = fileService.getAsList("Docs");


        log.debug("result got : {}", result);

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }
}
