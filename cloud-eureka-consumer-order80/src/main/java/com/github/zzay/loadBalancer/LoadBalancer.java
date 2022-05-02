package com.github.zzay.loadBalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zzay
 * @interfaceName LoadBalancer
 * @description Load Balancer
 * @create 2022/05/02 14:56
 * @see MyLoadBalancer
 */
public interface LoadBalancer {

    /**
     * Get a service instance using customized selection algorithm
     *
     * @param serviceInstances Service instances that can be reached currently
     * @return The service instance to be chose next under customized selection algorithm
     */
    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);

}
