package com.hkc.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 11:50
 */
@Configuration
public class FeignConfig {
     @Bean
    Logger.Level feignLoggerLevel(){

    return Logger.Level.FULL;

    }
}
