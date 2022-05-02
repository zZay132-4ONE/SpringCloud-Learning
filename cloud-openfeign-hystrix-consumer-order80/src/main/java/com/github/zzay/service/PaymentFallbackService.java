package com.github.zzay.service;

import org.springframework.stereotype.Component;

/**
 * @author zzay
 * @className PaymentFallbackService
 * @description Payment Fallback Service
 * @create 2022/05/02 18:08
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    /**
     * Fallback method of degradation of paymentInfo_OK
     *
     * @param id ID
     * @return Message
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "Failed to call the service (from: cloud-openfeign-hystrix-consumer-order80)";
    }

    /**
     * Fallback method of degradation of paymentInfo_TimeOut
     *
     * @param id ID
     * @return Message
     */
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "The interface called timed out or is abnormal.\t"
                + "Current thread: " + Thread.currentThread().getName();
    }

}
