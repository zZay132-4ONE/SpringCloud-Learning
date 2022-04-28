package com.github.zzay.service;

import com.github.zzay.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zzay
 * @className PaymentService
 * @description Payment Service
 * @create 2022/04/24 15:24
 * @see com.github.zzay.service.impl.PaymentServiceImpl
 */
public interface PaymentService {

    /**
     * Create a payment record
     *
     * @param payment Payment
     * @return Operation result
     */
    int create(Payment payment);

    /**
     * Get a payment record by ID
     *
     * @param id Payment ID
     * @return Payment record with the given ID
     */
    Payment getPaymentById(@Param("id") Long id);

}
