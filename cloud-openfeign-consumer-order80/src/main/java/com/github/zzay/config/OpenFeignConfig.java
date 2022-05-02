package com.github.zzay.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzay
 * @className OpenFeignConfig
 * @description Configurations about OpenFeign
 * @create 2022/05/02 15:57
 */
@Configuration
public class OpenFeignConfig {

    /**
     * Logger level of OpenFeign
     *
     * @return logger level of OpenFeign
     */
    @Bean
    Logger.Level openFeignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
