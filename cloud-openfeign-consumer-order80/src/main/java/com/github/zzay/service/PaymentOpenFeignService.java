package com.github.zzay.service;

import com.github.zzay.entity.Payment;
import com.github.zzay.result.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zzay
 * @interfaceName PaymentOpenFeignService
 * @description Service Class
 * @create 2022/05/02 15:28
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentOpenFeignService {

    /**
     * Get a payment record with the payment ID
     *
     * @param id Payment ID
     * @return A payment record with the payment ID
     */
    @GetMapping(value = "/payment/get/{id}")
    ResultBean<Payment> getPaymentById(@PathVariable(value = "id") Long id);

    /**
     * Test for the "timeout control" of OpenFeign
     *
     * @return Server port
     */
    @GetMapping(value = "/payment/openfeign/timeout")
    String paymentFeignTimeOut();

}
