package com.github.zzay.controller;

import com.github.zzay.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzay
 * @className OrderHystrixController
 * @description Order Controller - Hystrix
 * @create 2022/05/02 17:34
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "paymentInfoGlobalFallback")
public class OrderHystrixController {

    /**
     * Payment Service
     */
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    /**
     * Normal situation
     *
     * @param id ID
     * @return Message
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable(value = "id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    /**
     * Time out, service degradation
     *
     * @param id ID
     * @return Message
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallback",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String paymentInfo_TimeOut(@PathVariable(value = "id") Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    /**
     * Fallback method of paymentInfoTimeOut
     *
     * @param id ID
     * @return Fallback message
     */
    public String paymentInfoTimeOutFallback(@PathVariable(value = "id") Integer id) {
        return "This is customer 80, the debit system is busy, please try again 10 seconds later or please check whether you are running incorrectly";
    }

    /**
     * Global fallback method of paymentInfo
     *
     * @return Fallback message
     */
    public String paymentInfoGlobalFallback() {
        return "The server is now busy, please retry later ! (Global fallback method)";
    }

}
