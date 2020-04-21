package com.hkc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/18 14:56
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

   @GetMapping(value = "/payment/nacos/{id}")
    public  String   getPayment(@PathVariable("id") Integer id){

        return "springcloud nacos ,serverPort:"+serverPort+"  id:"+ id;
    }

}
