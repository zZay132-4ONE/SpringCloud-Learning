package com.github.zzay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzay
 * @className ConfigClientController
 * @description Config Client Controller
 * @create 2022/05/04 00:15
 */
@RestController
public class ConfigClientController {

    /**
     * Configuration information
     */
    @Value("${config.info}")
    private String configInfo;


    /**
     * Get configuration information
     *
     * @return configuration information
     */
    @GetMapping(value = "/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}
