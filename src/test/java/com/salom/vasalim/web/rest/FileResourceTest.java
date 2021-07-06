package com.salom.vasalim.web.rest;

import com.salom.vasalim.VasalimApplication;
import com.salom.vasalim.model.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@SpringBootTest(classes = VasalimApplication.class)
@RunWith(SpringRunner.class)
public class FileResourceTest {

    public static final String TEST_FILE_NAME = "test_file.txt";
    @Autowired
    private uz.devops.cardback.web.rest.FileResource fileResource;

    @Autowired
    private ApplicationProperties properties;


    @Test
    public void getRootFolders() {
        List<String> result = properties.getFolders();

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }


    @Test
    public void downloadPDFResourceToSuccess() throws Exception {
        HttpServletResponse httpServletResponse = getHttpServletResponse();
        assertThat(properties.getFolders()).isNotNull();
        assertThat(properties.getFolders()).isNotEmpty();
        fileResource.downloadPDFResource(httpServletResponse,
            TEST_FILE_NAME);
        assertThat(httpServletResponse).isNotNull();
        assertThat(false).isNotNull();
    }
    public HttpServletResponse getHttpServletResponse() {
        return new MockHttpServletResponse();
    }


}
