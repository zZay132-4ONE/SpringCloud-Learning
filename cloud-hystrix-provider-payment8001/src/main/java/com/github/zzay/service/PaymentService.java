package com.github.zzay.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zzay
 * @className PaymentService
 * @description Payment Service
 * @create 2022/05/02 17:11
 */
@Service
public class PaymentService {

    /**
     * Normal situation
     *
     * @param id ID
     * @return Message
     */
    public String paymentInfo_OK(Integer id) {
        return "Thread pool: " + Thread.currentThread().getName() + "\t"
                + "PaymentInfo_OK, id: " + id + "\t";
    }

    /**
     * Time out, service degradation
     *
     * @param id ID
     * @return Message
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallback",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread pool: " + Thread.currentThread().getName() + "\t"
                + "PaymentInfo_TimeOut (5s), id: " + id + "\t";
    }

    /**
     * Test for Hystrix circuit breaker
     *
     * @param id ID
     * @return Message
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
            commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            })
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("======== ID cannot be negative ========");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t"
                + "Successfully called, serial number: " + serialNum;
    }

    /**
     * Fallback method of payment circuit breaker
     *
     * @param id ID
     * @return Operation message
     */
    public String paymentCircuitBreakerFallback(@PathVariable(value = "id") Integer id) {
        return "ID cannot be negative, please try later ! (ID: " + id + ")";
    }

}
