package com.hkc.springcloud.service;

import com.hkc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 14:08
 */

public interface PaymentService {

    public int  create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
