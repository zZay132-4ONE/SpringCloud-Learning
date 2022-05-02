package com.github.zzay.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zzay
 * @interfaceName PaymentHystrixService
 * @description PaymentHystrixService
 * @create 2022/05/02 17:30
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    /**
     * Normal situation
     *
     * @param id ID
     * @return Message
     */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable(value = "id") Integer id);

    /**
     * Time out, service degradation
     *
     * @param id ID
     * @return Message
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable(value = "id") Integer id);

}
