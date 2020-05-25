package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.StreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class StreamProviderController {
    @Resource
    private StreamService streamService;

    @RequestMapping("streamSend")
    public String send(){
        String uuid = UUID.randomUUID().toString();
        streamService.send();
        return uuid;
    }
}
