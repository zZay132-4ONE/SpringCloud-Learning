package com.github.zzay.loadBalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zzay
 * @className MyLoadBalancer
 * @description My Load Balancer
 * @create 2022/05/02 14:56
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int cur, next;
        // CAS
        do {
            cur = this.atomicInteger.getAndIncrement();
            next = cur >= 2147483647 ? 0 : cur + 1;
        } while (!this.atomicInteger.compareAndSet(cur, next));
        System.out.println("======= next: " + next + " ========");
        return next;
    }

    /**
     * Get a service instance using customized selection algorithm
     *
     * @param serviceInstances Service instances that can be reached currently
     * @return The service instance to be chose next under customized selection algorithm
     */
    @Override
    public ServiceInstance getInstance (List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
