package com.hkc.springcloud.service.impl;

import com.hkc.springcloud.dao.PaymentDao;
import com.hkc.springcloud.entities.Payment;
import com.hkc.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 14:09
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {


        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentDao.getPaymentById(id);
    }
}
