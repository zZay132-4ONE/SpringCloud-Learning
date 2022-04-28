package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zzay
 * @className PaymentMain8002
 * @description Payment Service Provider - 8002 (Eureka)
 * @create 2022/04/28 22:18
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }

}
