package com.github.zzay.controller;

import com.github.zzay.entity.Payment;
import com.github.zzay.result.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zzay
 * @className OrderController
 * @description Order Controller
 * @create 2022/04/28 16:28
 */
@Slf4j
@RestController
public class OrderController {

    // URL of payment service
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    /**
     * RestTemplate instance
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Create a Payment record
     *
     * @param payment Payment
     * @return Operation result
     */
    @GetMapping(value = "/consumer/payment/create")
    public ResultBean<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ResultBean.class);
    }

    /**
     * Get a Payment record
     *
     * @param id Payment ID
     * @return Operation result
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public ResultBean<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResultBean.class);
    }

}
