package com.github.zzay.controller;

import com.github.zzay.entity.Payment;
import com.github.zzay.result.ResultBean;
import com.github.zzay.service.PaymentOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzay
 * @className OrderOpenFeignController
 * @description Payment Controlelr - 80 (OpenFeign)
 * @create 2022/05/02 15:31
 */
@Slf4j
@RestController
public class OrderOpenFeignController {

    @Autowired
    private PaymentOpenFeignService paymentOpenFeignService;

    /**
     * Get a payment record with the payment ID
     *
     * @param id Payment ID
     * @return A payment record with the payment ID
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    ResultBean<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        // Previous way
        // return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResultBean.class);
        return paymentOpenFeignService.getPaymentById(id);
    }

    /**
     * Test for the "timeout control" of OpenFeign
     *
     * @return Server port
     */
    @GetMapping(value = "/consumer/payment/openfeign/timeout")
    String paymentFeignTimeOut() {
        return paymentOpenFeignService.paymentFeignTimeOut();
    }

}
