package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zzay
 * @className OrderConsulMain80
 * @description Order Service Consumer - 80 (Consul)
 * @create 2022/04/29 01:01
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderConsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }

}
