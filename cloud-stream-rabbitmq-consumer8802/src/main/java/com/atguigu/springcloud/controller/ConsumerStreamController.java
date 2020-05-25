package com.atguigu.springcloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@EnableBinding(Sink.class)
public class ConsumerStreamController {

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        String s = message.getPayload();
        System.out.println(s);
    }
}
