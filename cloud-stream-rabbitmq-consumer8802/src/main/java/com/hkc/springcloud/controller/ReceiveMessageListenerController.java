package com.hkc.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * @author csc
 * @version 1.0
 * @date 2020/4/23 9:52
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public  void  input(Message<String> message){

        System.out.println("消费者8802号,--------->接受的消息:  "+message.getPayload()+"  serverPort: "+serverPort);

    }

}
