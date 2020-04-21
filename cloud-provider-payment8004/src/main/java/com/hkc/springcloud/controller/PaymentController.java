package com.hkc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/18 13:56
 */
@RestController
//@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private  String  serverPort;

    @RequestMapping(value = "/payment/zk")
    public  String paymentzk(){

        return "springcloud  zookeeper"+serverPort+"  "+UUID.randomUUID().toString();
    }
}
