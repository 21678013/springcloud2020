package com.hkc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 17:20
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {

        SpringApplication.run(EurekaMain7002.class,args);

    }
}
