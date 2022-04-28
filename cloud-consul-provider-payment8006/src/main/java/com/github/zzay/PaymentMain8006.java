package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zzay
 * @className PaymentMain8006
 * @description Payment Service Provider - 8006 (Consul)
 * @create 2022/04/29 00:54
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }

}
