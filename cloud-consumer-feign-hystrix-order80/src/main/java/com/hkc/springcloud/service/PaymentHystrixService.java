package com.hkc.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 15:29
 */
@Component
@FeignClient(value="CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface  PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String  paymentInfo_ok(@PathVariable("id") Integer  id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String  paymentInfo_timeout(Integer  id);




}
