package com.hkc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/23 15:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {

    // 75344872427186
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class,args);
    }

}
