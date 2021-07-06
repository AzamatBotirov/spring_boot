package com.salom.vasalim.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Properties specific to Card Back.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    /**
//     *
//     */
//    private Boolean isProduction;
//
//    /**
//     *
//     */
//    private Boolean planFeignSimulate;
//
//    /**
//     *
//     */
//    private Boolean simulatehub;
//
//    /**
//     *
//     */
//    private String springcontentpath;
//
//    /**
//     *
//     */
//    private String anorHubFeignSimulate;
//
//    /**
//     *
//     */
//    private Integer maxRetryHours;
//
//    /**
//     *
//     */
//    private Boolean elmaFeignSimulate;

    /**
     *
     */
    private List<String> folders;
}
