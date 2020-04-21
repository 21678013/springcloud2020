package com.hkc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/18 16:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {

    public static void main(String[] args) {

        SpringApplication.run(OrderNacosMain83.class,args);

    }
}
