package com.hkc.springcloud.controller;

import com.hkc.springcloud.service.IMessageProvider;
import com.netflix.eureka.V1AwareInstanceInfoConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/22 17:16
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider  messageProvider;

        @GetMapping(value = "/sendMessage")
        public String sendMessage(){

            return  messageProvider.send();

        }
}
