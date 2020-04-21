package com.hkc.springcloud.controller;

import com.hkc.springcloud.entities.CommonResult;
import com.hkc.springcloud.entities.Payment;
import com.hkc.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 10:23
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
private PaymentFeignService paymentFeignService;
   @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment>  getPaymentById(@PathVariable("id")  Long id){

      return paymentFeignService.getPaymentById(id);
    }


    @GetMapping(value="/consumer/payment/feign/timeout")
    public String  paymentFeignTimeout(){
        //默认一秒钟
         return paymentFeignService.paymentFeignTimeout();

    }
}
