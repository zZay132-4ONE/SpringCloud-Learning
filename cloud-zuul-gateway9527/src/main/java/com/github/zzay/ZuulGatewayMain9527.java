package com.github.zzay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zzay
 * @className com.github.zzay.ZuulGatewayMain9527
 * @description Zuul Gateway - 9527
 * @create 2022/05/02 20:18
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayMain9527.class, args);
    }

}
