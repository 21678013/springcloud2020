package com.hkc.springcloud.service;

import com.hkc.springcloud.entities.CommonResult;
import com.hkc.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 10:16
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

   // CommonResult<Payment> getPaymentById(@Param("id") Long id);

   @GetMapping(value = "/payment/get/{id}")
   public CommonResult<Payment>  getPaymentById(@PathVariable("id") Long id);

   @GetMapping(value="/payment/feign/timeout")
   public String  paymentFeignTimeout();


}
