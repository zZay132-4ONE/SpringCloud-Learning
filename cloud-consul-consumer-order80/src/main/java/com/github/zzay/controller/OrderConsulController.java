package com.github.zzay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zzay
 * @className OrderConsulController
 * @description Order Controller (Consul)
 * @create 2022/04/29 01:05
 */
@Slf4j
@RestController
public class OrderConsulController {

    // URL invoked
    public static final String INVOKE_URL = "http://CONSUL-PROVIDER-PAYMENT";

    /**
     * RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Call payment service provided by providers through Consul
     *
     * @return Info
     */
    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        System.out.println("Consumer called \"payment\" service (consul); result: )" + result);
        return result;
    }

}
