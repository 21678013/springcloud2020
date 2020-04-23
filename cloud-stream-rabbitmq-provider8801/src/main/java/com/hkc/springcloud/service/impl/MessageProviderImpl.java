package com.hkc.springcloud.service.impl;

import com.hkc.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author csc
 * @version 1.0
 * @date 2020/4/22 17:05
 */
@EnableBinding(Source.class)//定义消息推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String  serial=UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*******serial: "+serial);
        return null;
    }
}
