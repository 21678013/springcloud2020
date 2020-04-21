package com.hkc.springcloud.controller;


import com.hkc.springcloud.entities.CommonResult;
import com.hkc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 15:07
 */
@RestController
@Slf4j
public class OrderController {
   // public static final  String  PAYMENT_URL="http://localhost:8001";
    //服务名称
   public static final  String  PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment>  create(Payment payment){

      return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);

    }
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment>  getPayment(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

    }

    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment>  getPayment2(@PathVariable("id") Long id){

        ResponseEntity<CommonResult>  entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"");
                return entity.getBody();
        }else{

            return  new CommonResult<>(444,"操作失败");
        }

    }
}
