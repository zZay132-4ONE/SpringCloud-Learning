package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zzay
 * @className OrderOpenFeignMain80
 * @description Order Service Consumer - 80 (Eureka - OpenFeign)
 * @create 2022/05/02 15:26
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain80.class, args);
    }

}
