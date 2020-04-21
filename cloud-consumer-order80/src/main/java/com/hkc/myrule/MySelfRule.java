package com.hkc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/20 9:18
 * 不能和启动类一级目录
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule  myRule(){

        return new RandomRule();//随机
    }
}
