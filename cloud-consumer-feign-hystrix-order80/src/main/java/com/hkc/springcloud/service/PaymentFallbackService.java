package com.hkc.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 17:14
 */
@Component
public class PaymentFallbackService implements  PaymentHystrixService
{
    @Override
    public String paymentInfo_ok(Integer id) {

        return "-----PaymentFallbackService  fall back-paymentInfo_ok,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {

        return "PaymentFallbackService fall  back-paymentInfo_timeout,o(╥﹏╥)o";
    }
}
