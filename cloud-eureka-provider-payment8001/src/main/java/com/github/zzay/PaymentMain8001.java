package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zzay
 * @className PaymentMain8001
 * @description Payment Service Provider - 8001 (Eureka)
 * @create 2022/04/24 12:36
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }

}
