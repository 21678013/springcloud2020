package com.hkc.springcloud;

import com.hkc.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 14:59
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)//改用自定义的负责均衡组件
public class OrderMain80 {
    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class,args);


    }
}
