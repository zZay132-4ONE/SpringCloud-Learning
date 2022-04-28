package com.github.zzay.dao;

import com.github.zzay.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zzay
 * @interfaceName PaymentDao
 * @description Payment DAO
 * @create 2022/04/24 14:22
 */
@Mapper
@Repository
public interface PaymentDao {

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
