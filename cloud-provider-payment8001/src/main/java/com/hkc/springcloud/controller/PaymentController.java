package com.hkc.springcloud.controller;

import com.hkc.springcloud.entities.CommonResult;
import com.hkc.springcloud.entities.Payment;
import com.hkc.springcloud.service.PaymentService;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 14:14
 */
@RestController
@Slf4j
public class PaymentController {


    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

       int result= paymentService.create(payment);
       log.info("*****插入结果:"+result);
       if(result>0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
       }else
       {
           return new CommonResult(444,"插入数据库失败,serverPort:"+serverPort,null) ;
       }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

       Payment payment= paymentService.getPaymentById(id);
        log.info("*****查询结果:"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询数据库成功:serverPort:"+serverPort,payment);
        }else
        {
            return new CommonResult(444,"没有记录,查询id:"+id+" serverPort:"+serverPort,null) ;
        }
    }
        @GetMapping(value="/payment/discovery")
        public Object discovery(){

            List<String> services = discoveryClient.getServices();
            for (String element:services) {
              log.info("*****element"+element);

            }

            List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

            for (ServiceInstance instance:instances) {

                log.info("****服务:"+instance.getServiceId()+" 主机:"+instance.getHost()+" 端口:"+instance.getPort()+" 地址:"+instance.getUri());
            }
            return this.discoveryClient;

        }
        @GetMapping(value = "/payment/feign/timeout")
        public String  paymentFeignTimeout(){

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return serverPort;
        }

       @GetMapping(value = "/payment/lb")
        public String  getPaymentLB(){

            return serverPort;
        }

}
