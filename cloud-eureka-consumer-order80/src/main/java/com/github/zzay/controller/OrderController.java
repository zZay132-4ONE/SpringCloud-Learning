package com.github.zzay.controller;

import com.github.zzay.entity.Payment;
import com.github.zzay.loadBalancer.LoadBalancer;
import com.github.zzay.result.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
     * Service discovery client
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * Customized load balancer
     */
    @Autowired
    private LoadBalancer loadBalancer;

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

    /**
     * Get a Payment record
     *
     * @param id Payment ID
     * @return Operation result
     */
    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public ResultBean<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<ResultBean> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, ResultBean.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new ResultBean(HttpStatus.BAD_REQUEST.value(), "Failed to get the payement record.");
        }
    }

    /**
     * Select the next service instance under customized selection algorithm,
     * and call restTemplate to get for it
     *
     * @return Operation result
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        // Service instances that can be reached currently
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (serviceInstanceList == null || serviceInstanceList.size() <= 0) {
            return null;
        }
        // Select the next service instance under customized selection algorithm
        ServiceInstance serviceInstance = loadBalancer.getInstance(serviceInstanceList);
        // Get the URI of the chosen service instance, and call restTemplate to get it
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
