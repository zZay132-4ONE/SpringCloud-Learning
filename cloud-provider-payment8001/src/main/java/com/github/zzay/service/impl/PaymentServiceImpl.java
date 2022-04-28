package com.github.zzay.service.impl;

import com.github.zzay.dao.PaymentDao;
import com.github.zzay.entity.Payment;
import com.github.zzay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zzay
 * @className PaymentServiceImpl
 * @description Payment Service Implementation
 * @create 2022/04/24 15:25
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * Payment DAO
     */
    @Autowired
    private PaymentDao paymentDao;

    /**
     * Create a payment record
     *
     * @param payment Payment
     * @return Operation result
     */
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * Get a payment record by ID
     *
     * @param id Payment ID
     * @return Payment record with the given ID
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
