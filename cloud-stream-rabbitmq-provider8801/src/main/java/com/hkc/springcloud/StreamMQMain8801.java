package com.hkc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/22 17:03
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8801 {

    public static void main(String[] args) {

        SpringApplication.run(StreamMQMain8801.class,args);

    }
}
