package com.github.zzay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zzay
 * @className OrderZkController
 * @description Order Controller (Zookeeper)
 * @create 2022/04/29 00:42
 */
@RestController
public class OrderZkController {

    // URL invoked
    public static final String INVOKE_URL = "http://CLOUD-PROVIDER-PAYMENT";

    /**
     * RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Call payment service provided by providers through zookeeper
     *
     * @return Info
     */
    @RequestMapping(value = "/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        System.out.println("Consumer called \"payment\" service (zookeeper); result: )" + result);
        return result;
    }

}
