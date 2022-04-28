package com.github.zzay.controller;

import com.github.zzay.entity.Payment;
import com.github.zzay.result.ResultBean;
import com.github.zzay.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zzay
 * @className PaymentController
 * @description Payment Controller
 * @create 2022/04/24 15:28
 */
@Slf4j
@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    // Service ID
    public static final String SERVICE_ID = "CLOUD-PAYMENT-SERVICE";

    /**
     * Server port
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * Service Discovery Client
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * Payment Service
     */
    @Autowired
    private PaymentService paymentService;

    /**
     * Create a payment record
     *
     * @param payment Payment
     * @return Operation result
     */
    @PostMapping(value = "create")
    public ResultBean create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("======== Insertion Result: " + result + " ========");
        if (result > 0) {
            return new ResultBean(HttpStatus.OK.value(), "Successfully inserted a Payment record; Server port: " + serverPort, result);
        } else {
            return new ResultBean(HttpStatus.BAD_REQUEST.value(), "Failed to insert a Payment record; Server port: " + serverPort, null);
        }
    }

    /**
     * Get a payment record by ID
     *
     * @param id Payment ID
     * @return Payment record with the given ID
     */
    @GetMapping(value = "get/{id}")
    public ResultBean getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("======== Query Result: " + payment + " ========");
        if (payment != null) {
            return new ResultBean(HttpStatus.OK.value(), "Successfully queried a Payment record with ID-" + id + "; Server port: " + serverPort, payment);
        } else {
            return new ResultBean(HttpStatus.BAD_REQUEST.value(), "Failed to queried a Payment record with ID-" + id + "; Server port: " + serverPort, null);
        }
    }

    /**
     * Service Discovery
     *
     * @return DiscoveryClient
     */
    @GetMapping(value = "/discovery")
    public Object discovery() {
        // print IDs of services
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        // print information of Service instances
        List<ServiceInstance> instances = discoveryClient.getInstances(SERVICE_ID);
        for (ServiceInstance instance : instances) {
            System.out.println(" Service ID: " + instance.getServiceId() + "\t"
                    + "Instance ID: " + instance.getInstanceId()
                    + "Host: " + instance.getHost() + "\t"
                    + "Port: " + instance.getPort() + "\t"
                    + "URI: " + instance.getUri()+ "\t"
                    + "Scheme: " + instance.getScheme()+ "\t"
                    + "Metadata: " + instance.getMetadata());
        }
        return this.discoveryClient;
    }

}
