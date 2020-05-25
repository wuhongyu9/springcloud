package com.atguigu.springcloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class CloudStreamConsumerController {
    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        String s = message.getPayload();
        System.out.println(s);
    }
}
