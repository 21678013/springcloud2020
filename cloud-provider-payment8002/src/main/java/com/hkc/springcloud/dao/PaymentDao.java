package com.hkc.springcloud.dao;

import com.hkc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 13:47
 */
@Mapper
public interface PaymentDao {

    public int  create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
