package com.github.zzay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zzay
 * @className PaymentController
 * @description Payment Controller (Consul)
 * @create 2022/04/29 00:56
 */
@Slf4j
@RestController(value = "payment")
public class PaymentController {

    /**
     * Server port
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * Do things
     *
     * @return Info
     */
    @RequestMapping(value = "consul")
    public String paymentZk() {
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
