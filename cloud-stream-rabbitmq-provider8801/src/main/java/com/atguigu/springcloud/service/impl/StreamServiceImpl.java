package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.StreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
@Slf4j
public class StreamServiceImpl implements StreamService {
    @Resource
    private MessageChannel output;

    @Override
    public void send() {
        String uuid = UUID.randomUUID().toString();
        log.info("**********"+uuid+"**********");
        output.send(MessageBuilder.withPayload(uuid).build());
    }
}
