package com.github.zzay.controller;

import com.github.zzay.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

    /**
 * @author zzay
 * @className PaymentController
 * @description Payment Controller (Eureka - Hystrix)
 * @create 2022/05/02 17:13
 */
@Slf4j
@RestController
public class PaymentController {

    /**
     * Server port
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * Payment Service
     */
    @Autowired
    private PaymentService paymentService;

    /**
     * Normal situation
     *
     * @param id ID
     * @return Message
     */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("======== Result: " + result + " ========");
        return result;
    }

    /**
     * Time out, service degradation
     *
     * @param id ID
     * @return Message
     */
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("======== Result: " + result + " ========");
        return result;
    }

    /**
     * Test for Hystrix circuit breaker
     *
     * @param id ID
     * @return Message
     */
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("======== Result: " + result + " ========");
        return result;
    }

}
