package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zzay
 * @className OrderOpenFeignHystrixMain80
 * @description Order Consumer Service - 80 (OpenFeign Hystrix)
 * @create 2022/05/02 17:29
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderOpenFeignHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignHystrixMain80.class, args);
    }

}
