package com.github.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zzay
 * @className ApplicationContextConfig
 * @description Application Context Configuration
 * @create 2022/04/29 01:04
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * Get a RestTemplate instance
     *
     * @return A RestTemplate instance
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
