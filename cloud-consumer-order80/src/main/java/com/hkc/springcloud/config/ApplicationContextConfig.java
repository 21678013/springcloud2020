package com.hkc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/16 15:09
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * 两个注解代表支持负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){


        return new RestTemplate();
    }


}
