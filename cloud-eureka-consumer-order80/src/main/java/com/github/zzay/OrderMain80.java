package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zzay
 * @className OrderMain80
 * @description Order Service Consumer - 80 (Eureka)
 * @create 2022/04/28 16:24
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
