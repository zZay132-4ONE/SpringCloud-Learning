package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zzay
 * @className PaymentMain8004
 * @description Payment Service Provider - 8004 (Zookeeper)
 * @create 2022/04/29 00:25
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }

}
